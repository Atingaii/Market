package cn.zy.domain.activity.service;

import cn.zy.domain.activity.model.entity.MarketProductEntity;
import cn.zy.domain.activity.model.entity.TrialBalanceEntity;

/**
 * @author zy
 */
public interface IIndexGroupBuyMarketService {

    TrialBalanceEntity indexMarketTrial(MarketProductEntity marketProductEntity) throws Exception;

}
