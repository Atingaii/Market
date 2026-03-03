package cn.zy.domain.activity.service.trial.node;

import cn.zy.domain.activity.model.entity.MarketProductEntity;
import cn.zy.domain.activity.model.entity.TrialBalanceEntity;
import cn.zy.domain.activity.service.trial.AbstractGroupBuyMarketSupport;
import cn.zy.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.zy.types.design.framework.tree.StrategyHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * @author Huli
 */
@Slf4j
@Service
public class EndNode extends AbstractGroupBuyMarketSupport<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> {

    @Override
    public TrialBalanceEntity apply(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return null;
    }

    @Override
    public StrategyHandler<MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, TrialBalanceEntity> get(MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws Exception {
        return null;
    }

}
