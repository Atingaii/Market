package cn.zy.domain.activity.service.trial;

import cn.zy.domain.activity.adapter.repository.IActivityRepository;
import cn.zy.domain.activity.service.trial.factory.DefaultActivityStrategyFactory;
import cn.zy.types.design.framework.tree.AbstractMultiThreadStrategyRouter;

import javax.annotation.Resource;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

/**
 * @author zy
 * @description 抽象的拼团营销支撑类
 * @create 2024-12-14 13:42
 */
public abstract class AbstractGroupBuyMarketSupport<MarketProductEntity, DynamicContext, TrialBalanceEntity> extends AbstractMultiThreadStrategyRouter<cn.zy.domain.activity.model.entity.MarketProductEntity, DefaultActivityStrategyFactory.DynamicContext, cn.zy.domain.activity.model.entity.TrialBalanceEntity> {

    protected long timeout = 500;
    @Resource
    protected IActivityRepository repository;

    @Override
    protected void multiThread(cn.zy.domain.activity.model.entity.MarketProductEntity requestParameter, DefaultActivityStrategyFactory.DynamicContext dynamicContext) throws ExecutionException, InterruptedException, TimeoutException {
        // 缺省的方法
    }

}
