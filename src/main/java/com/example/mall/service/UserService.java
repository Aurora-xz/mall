package com.example.mall.service;

import com.example.mall.dao.UserDao;
import com.example.mall.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    private UserDao userDao;

    //判断用户是否添加成功
    public boolean registerUser(User user) {
        if (!userDao.isUsernameExists(user.getUsername())) {
            userDao.registerUser(user);
            return true;
        } else
            return false;
    }


    public User findUserByNameAndPwd(String username, String password) {
        return userDao.findUserByNameAndPwd(username, password);
    }

    public void updateUserAmount(User user) {
        userDao.updateUserAmount(user);
    }

    public void updateUserDestination(User user) {
        userDao.updateUserDestination(user);
    }
}
