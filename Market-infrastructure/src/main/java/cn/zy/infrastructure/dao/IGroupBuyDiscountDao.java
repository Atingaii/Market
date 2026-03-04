package cn.zy.infrastructure.dao;

import cn.zy.infrastructure.dao.po.GroupBuyDiscount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zy
 * @description 折扣配置Dao
 * @create 2024-12-07 10:10
 */
@Mapper
public interface IGroupBuyDiscountDao {

    // 查询折扣有哪些
    List<GroupBuyDiscount> queryGroupBuyDiscountList();

    // 根据传入的 discountId 去表 group_buy_discount 查询一条（或多条）优惠信息
    GroupBuyDiscount queryGroupBuyActivityDiscountByDiscountId(String discountId);
}
