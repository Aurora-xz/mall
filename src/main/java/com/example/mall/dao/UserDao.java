package com.example.mall.dao;

import com.example.mall.mapper.UserMapper;
import com.example.mall.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    //注册添加用户
    public void registerUser(User user) {
        userMapper.registerUser(user);
    }

    //查找是否有相同username的用户 存在返回true
    public boolean isUsernameExists(String username) {
        return userMapper.findUserByName(username) != null;
    }

    public User findUserByNameAndPwd(String username, String password) {
        return userMapper.findUserByNameAndPwd(username, password);
    }

    public void updateUserAmount(User user) {
        userMapper.updateUserAmount(user);
    }

    public BigDecimal getAmountById(Integer userId) {
        return userMapper.getAmountById(userId);
    }

    public void reduceAmount(Integer userId, BigDecimal price) {
        userMapper.reduceAmount(userId, price);
    }

    public void updateUserDestination(User user) {
        userMapper.updateDestination(user);
    }
}
