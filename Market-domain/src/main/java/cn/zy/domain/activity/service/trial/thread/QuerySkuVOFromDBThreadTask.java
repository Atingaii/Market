package cn.zy.domain.activity.service.trial.thread;

import cn.zy.domain.activity.adapter.repository.IActivityRepository;
import cn.zy.domain.activity.model.valobj.SkuVO;

import java.util.concurrent.Callable;

/**
 * @author zy
 * @description 查询商品信息任务
 * @create 2024-12-21 10:51
 */
public class QuerySkuVOFromDBThreadTask implements Callable<SkuVO> {

    private final String goodsId;

    private final IActivityRepository activityRepository;

    public QuerySkuVOFromDBThreadTask(String goodsId, IActivityRepository activityRepository) {
        this.goodsId = goodsId;
        this.activityRepository = activityRepository;
    }

    @Override
    public SkuVO call() throws Exception {
        return activityRepository.querySkuByGoodsId(goodsId);
    }

}
