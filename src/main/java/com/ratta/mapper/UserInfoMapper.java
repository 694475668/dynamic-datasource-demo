package com.ratta.mapper;


import com.ratta.annotation.TargetDataSource;
import com.ratta.model.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

/**
 * @author 刘明
 */
public interface UserInfoMapper {

    /**
     * 从TEST1数据源中获取用户信息
     */
    @TargetDataSource("master")
    UserInfo selectByOddUserId(Integer id);

    /**
     * 从test2数据源中获取用户信息
     */
    @TargetDataSource("slave")
    UserInfo selectByEvenUserId(Integer id);

    /**
     * 添加
     *
     * @param userInfo
     * @return
     */
    @TargetDataSource("master")
    @Insert("INSERT INTO user_info values(0,#{userName},#{userAge},#{address},now(),#{remarks})")
    int insert(UserInfo userInfo);

    /**
     * 修改
     *
     * @param userInfo
     * @return
     */
    @TargetDataSource("master")
    @Update("update user_info set user_name=#{userName},user_age=#{userAge},address=#{address} where id=#{id}")
    int update(UserInfo userInfo);

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @TargetDataSource("master")
    @Delete("delete from user_info where id =#{id}")
    int delete(int id);
}