package cn.zy.domain.activity.service.trial.node;

import cn.zy.domain.activity.model.entity.MarketProductEntity;
import cn.zy.domain.activity.model.entity.TrialBalanceEntity;
import cn.zy.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import cn.zy.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.zy.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author zy
 * @description 开关节点
 * @create 2024-12-14 14:27
 */
@Slf4j
@Service
public class SwitchNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Resource
    private MarketNode marketNode;

    @Override
    public TrialBalanceEntity doApply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return router(requestParameter, dynamicContext);
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return marketNode;
    }

}
