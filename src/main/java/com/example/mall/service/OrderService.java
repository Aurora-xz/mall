package com.example.mall.service;

import com.example.mall.dao.CartDao;
import com.example.mall.dao.OrderDao;
import com.example.mall.dao.ProductDao;
import com.example.mall.dao.UserDao;
import com.example.mall.pojo.Order;
import com.example.mall.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class OrderService {
    @Autowired
    private OrderDao orderDao;
    @Autowired
    private UserDao userDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CartDao cartDao;

    public List<Order> getOrdersByUid(Integer userId) {
        return orderDao.getOrdersByUid(userId);
    }

    public void buyProduct(Integer userId, Integer pId, Order order) {
        BigDecimal amount = userDao.getAmountById(userId);
        BigDecimal price = productDao.getPriceById(pId);
        if (amount.compareTo(price) < 0) {
            return;
        }
        userDao.reduceAmount(userId, price);
        productDao.reduceStock(pId);
        orderDao.insertOrder(order);
        cartDao.deleteCartByTwoId(userId,pId);
    }

    public Order findOrderByTwoId(Integer userId, Integer pId) {
        return orderDao.findOrderByTwoId(userId, pId);
    }

    public void deleteOrder(Order order) {
        orderDao.deleteOrder(order);
    }

    public List<Order> getOrdersByPid(int pid) {
        return orderDao.getOrdersByPid(pid);
    }

    public Order getOrderById(Integer id) {
        return orderDao.getOrderById(id);
    }

    public void updateOrder(Order order) {
        orderDao.updateOrder(order);
    }
}
