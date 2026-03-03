package cn.zy.domain.activity.service.trial;

import cn.zy.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.zy.types.design.framework.tree.AbstractStrategyRouter;


/**
 * @author Huli
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity,
        DynamicContext, TrialBalanceEntity> extends AbstractStrategyRouter<cn.zy.domain.activity.model.entity.MarketProductEntity,
        DefaultActivityStrategyFactory.DynamicContext,
        cn.zy.domain.activity.model.entity.TrialBalanceEntity> {



}
