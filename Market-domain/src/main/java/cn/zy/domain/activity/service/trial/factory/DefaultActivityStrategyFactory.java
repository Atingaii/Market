package cn.zy.domain.activity.service.trial.factory;

import cn.zy.domain.activity.model.entity.MarketProductEntity;
import cn.zy.domain.activity.model.entity.TrialBalanceEntity;
import cn.zy.domain.activity.service.trial.node.RootNode;
import cn.zy.types.design.framework.tree.StrategyHandler;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;


/**
 * @author Huli
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

    }

}
