package com.example.mall.service;

import com.example.mall.dao.CartDao;
import com.example.mall.pojo.Cart;
import com.example.mall.pojo.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CartService {
    @Autowired
    private CartDao cartDao;
    @Autowired
    private ProductService productService;

    public List<Product> getProductsInCartByUserId(Integer userId) {
        List<Integer> productIds = cartDao.getProductIdsByUserId(userId);
        List<Product> products = new ArrayList<>();
        for (Integer id : productIds) {
            products.add(productService.getProductById(id));
        }
        return products;
    }

    public void addCart(Integer userId, Integer pId) {
        Cart cart = cartDao.findByTwoId(userId, pId);
        if (cart == null)
            cartDao.insertCart(userId, pId);
    }

    public void deleteCart(Integer userId, Integer pid) {
        cartDao.deleteCartByTwoId(userId, pid);
    }
}
