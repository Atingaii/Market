package cn.zy.infrastructure.dao;

import cn.zy.infrastructure.dao.po.GroupBuyActivity;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author zy
 * @description 拼团活动 DAO
 * @create 2024-12-07 10:10
 */
@Mapper
public interface IGroupBuyActivityDao {

    // 选出活动有哪些
    List<GroupBuyActivity> queryGroupBuyActivityList();
    // 选出有效的活动
    GroupBuyActivity queryValidGroupBuyActivity(GroupBuyActivity groupBuyActivityReq);
}
