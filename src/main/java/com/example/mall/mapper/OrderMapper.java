package com.example.mall.mapper;

import com.example.mall.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    List<Order> getOrdersByUid(@Param("uId") Integer userId);

    void insertOrder(Order order);

    Order findOrderByTwoId(@Param("uId") Integer userId, @Param("pId") Integer pId);

    void deleteOrder(Order order);

    List<Order> getOrdersByPid(@Param("pid") int pid);

    Order getOrderById(@Param("id") Integer id);

    void updateOrder(Order order);
}
