package com.example.mall.dao;

import com.example.mall.mapper.OrderMapper;
import com.example.mall.pojo.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OrderDao {
    @Autowired
    private OrderMapper orderMapper;

    public List<Order> getOrdersByUid(Integer userId) {
        return orderMapper.getOrdersByUid(userId);
    }

    public void insertOrder(Order order) {
        orderMapper.insertOrder(order);
    }

    public Order findOrderByTwoId(Integer userId, Integer pId) {
        return orderMapper.findOrderByTwoId(userId, pId);
    }

    public void deleteOrder(Order order) {
        orderMapper.deleteOrder(order);
    }

    public List<Order> getOrdersByPid(int pid) {
        return orderMapper.getOrdersByPid(pid);
    }

    public Order getOrderById(Integer id) {
        return orderMapper.getOrderById(id);
    }

    public void updateOrder(Order order) {
        orderMapper.updateOrder(order);
    }
}
