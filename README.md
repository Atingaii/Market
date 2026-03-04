### 项目重构记录

## 2026-03-03｜策略路由工厂命名优化与编译问题修复

### 本次主要完成内容
1. 策略工厂方法完成语义化命名统一。
2. 业务服务调用链完成同步更新。
3. `DynamicContext` 构造器冲突问题完成修复，恢复模块可编译状态。

### 核心交付清单
1. `DefaultActivityStrategyFactory` 方法名由 `strategyHandler()` 调整为 `getRootHandler()`，明确返回“策略树根处理器”。
2. `IndexGroupBuyMarketServiceImpl` 中的调用已切换为 `defaultActivityStrategyFactory.getRootHandler()`。
3. `DefaultActivityStrategyFactory.DynamicContext` 移除 `@AllArgsConstructor`，避免与 `@NoArgsConstructor` 生成重复无参构造器。

### 影响范围
1. 仅涉及策略工厂与调用方，未变更领域路由规则与业务计算逻辑。
2. 不影响模块分层结构与依赖方向。

### 当前状态
1. 工程已可通过 `mvn -q -DskipTests compile` 编译。
2. 策略树节点已完成主链路打通，`RootNode -> SwitchNode -> MarketNode -> EndNode` 可执行并返回试算结果。

## 2026-03-04｜策略树节点落地与执行链路梳理（重点）

### 这次到底新增了什么
这次的核心不是“多写几个类”，而是把策略树从“能编译”推进到“能跑通”：

1. `RootNode` 补齐入参校验与根路由，负责第一跳分发到 `SwitchNode`。
2. `SwitchNode` 补齐开关路由逻辑，负责转发到 `MarketNode`。
3. `MarketNode` 补齐异步预加载能力：
   - 并发查询活动配置 `GroupBuyActivityDiscountVO`
   - 并发查询商品信息 `SkuVO`
   - 将结果写入 `DynamicContext`，供后续节点复用
4. `EndNode` 补齐收口逻辑，基于上下文组装 `TrialBalanceEntity` 返回。
5. 两个异步任务类完成接入：
   - `QueryGroupBuyActivityDiscountVOThreadTask`
   - `QuerySkuVOFromDBThreadTask`

### 重点：节点执行流程（get / router / apply / doApply）

先记一条总规则：  
`apply = multiThread + doApply`  
`router = get + next.apply`

完整执行链如下：

```text
IndexGroupBuyMarketServiceImpl.indexMarketTrial()
  -> strategyHandler.apply(...)                 // RootNode.apply
     -> RootNode.multiThread()                  // 默认空实现
     -> RootNode.doApply()
        -> RootNode.router()
           -> RootNode.get()                    // 返回 SwitchNode
           -> SwitchNode.apply(...)
              -> SwitchNode.multiThread()       // 默认空实现
              -> SwitchNode.doApply()
                 -> SwitchNode.router()
                    -> SwitchNode.get()         // 返回 MarketNode
                    -> MarketNode.apply(...)
                       -> MarketNode.multiThread()
                          -> 并发查询活动配置/商品信息并写入 DynamicContext
                       -> MarketNode.doApply()
                          -> MarketNode.router()
                             -> MarketNode.get() // 返回 EndNode
                             -> EndNode.apply(...)
                                -> EndNode.multiThread() // 默认空实现
                                -> EndNode.doApply()     // 组装并返回 TrialBalanceEntity
```

### 关键理解（避免再绕）
1. `get()` 只做一件事：决定“下一跳是谁”。
2. `router()` 只做两步：先 `get()`，再执行 `next.apply()`。
3. `apply()` 是节点统一入口：先准备数据（`multiThread`），再处理业务（`doApply`）。
4. `doApply()` 里如果继续 `router()`，链路就会向后流转；不再 `router()` 就在当前节点结束。

### 当前里程碑状态
1. 策略树主链路已可运行并串联上下文数据。
2. `MarketNode` 的“拼团优惠试算”细节仍保留 `todo`，下一步聚焦真实扣减规则与可见性判定。
