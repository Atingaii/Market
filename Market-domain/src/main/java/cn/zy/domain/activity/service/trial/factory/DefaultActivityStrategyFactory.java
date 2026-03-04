package cn.zy.domain.activity.service.trial.factory;

import cn.zy.domain.activity.model.entity.MarketProductEntity;
import cn.zy.domain.activity.model.entity.TrialBalanceEntity;
import cn.zy.domain.activity.model.valobj.GroupBuyActivityDiscountVO;
import cn.zy.domain.activity.model.valobj.SkuVO;
import cn.zy.domain.activity.service.trial.node.RootNode;
import cn.zy.types.design.framework.tree.StrategyHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author zy
 * @description 活动策略工厂
 * @create 2024-12-14 13:41
 */
@Service
public class DefaultActivityStrategyFactory {

    private final RootNode rootNode;

    public DefaultActivityStrategyFactory(RootNode rootNode) {
        this.rootNode = rootNode;
    }

    public StrategyHandler<MarketProductEntity, DynamicContext, TrialBalanceEntity> strategyHandler() {
        return rootNode;
    }

    @Data
    @Builder
    @AllArgsConstructor
    @NoArgsConstructor
    public static class DynamicContext {
        // 拼团活动营销配置值对象
        private GroupBuyActivityDiscountVO groupBuyActivityDiscountVO;
        // 商品信息
        private SkuVO skuVO;
    }

}
