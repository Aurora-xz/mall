package com.example.mall.mapper;

import com.example.mall.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

@Mapper
public interface UserMapper {

    /*添加用户*/
    void registerUser(User user);

    //查找是否已经存在用户名为username的用户
    User findUserByName(@Param("username") String username);

    User findUserByNameAndPwd(@Param("username") String username, @Param("password") String password);

    void updateUserAmount(User user);

    BigDecimal getAmountById(@Param("id") Integer userId);

    void reduceAmount(@Param("id") Integer userId, @Param("price") BigDecimal price);

    void updateDestination(User user);
}
