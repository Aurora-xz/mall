package com.example.mall.service;

import com.example.mall.MallApplication;
import com.example.mall.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringBootTest
@SpringJUnitConfig(classes = MallApplication.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void addUserTest() {
        User user = new User();
        user.setUsername("root");
        user.setPassword("123456");
        user.setRole(0);
        userService.registerUser(user);
    }
}
