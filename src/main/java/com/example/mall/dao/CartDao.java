package com.example.mall.dao;

import com.example.mall.mapper.CartMapper;
import com.example.mall.pojo.Cart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CartDao {
    @Autowired
    private CartMapper cartMapper;

    public List<Integer> getProductIdsByUserId(Integer userId) {
        return cartMapper.getProductIdsByUserId(userId);
    }

    public void insertCart(Integer userId, Integer pId) {
        cartMapper.insertCart(userId, pId);
    }

    public Cart findByTwoId(Integer userId, Integer pId) {
        return cartMapper.findByUIdAndPId(userId, pId);
    }

    public void deleteCartByTwoId(Integer userId, Integer pid) {
        cartMapper.deleteByTwoId(userId, pid);
    }
}
