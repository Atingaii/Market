package cn.zy.infrastructure.dao;

import cn.zy.infrastructure.dao.po.Sku;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author zy
 * @description 商品查询
 * @create 2024-12-21 10:48
 */
@Mapper
public interface ISkuDao {

    Sku querySkuByGoodsId(String goodsId);

}
