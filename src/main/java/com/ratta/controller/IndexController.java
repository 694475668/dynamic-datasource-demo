package com.ratta.controller;

import com.ratta.mapper.UserInfoMapper;
import com.ratta.model.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 将@Transactional注解由原来的类注解改为具体到方法上，
 * 而且一般用到@Transactional的地方都是增删改，而且只要涉及到增删改的请求
 * （即使可能附带查询）都是要使用master数据源的。所以，
 * 最终我们将@Transactional注解指定到具体某个增删改的方法上，@TargetDataSource
 * 依然是在mapper的方法中
 *
 * @author 刘明
 */
@RestController
public class IndexController {
    /**
     * 这是是测试环节我就省略没有写service了直接调用mapper
     * 层
     */
    @Resource
    private UserInfoMapper userInfoMapper;

    @GetMapping("/test1")
    public UserInfo getIndex1() {
        return userInfoMapper.selectByOddUserId(1);
    }

    @GetMapping("/test2")
    public UserInfo getIndex2() {
        return userInfoMapper.selectByEvenUserId(1);
    }

    @GetMapping("/insert")
    public void insert() {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("zhangsan");
        userInfo.setAddress("tianjin");
        userInfo.setUserAge(22);
        userInfo.setRemarks("xixihaha");
        userInfoMapper.insert(userInfo);
    }

    @GetMapping("/update/{id}")
    public void update(@PathVariable("id") Integer id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserName("lisi");
        userInfo.setAddress("beijing");
        userInfo.setUserAge(22);
        userInfo.setRemarks("ouye");
        userInfo.setId(id);
        userInfoMapper.update(userInfo);
    }

    @GetMapping("/delete/{id}")
    public void delete(@PathVariable("id") Integer id) {
        userInfoMapper.delete(id);
    }

}
