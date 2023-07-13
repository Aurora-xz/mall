package com.example.mall.controller.consumer;

import com.example.mall.pojo.Order;
import com.example.mall.pojo.User;
import com.example.mall.service.OrderService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Timestamp;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

@Controller
public class userOrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/consumer/order")
    public String ViewOrders(Model model, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        List<Order> orders = orderService.getOrdersByUid(userId);
        model.addAttribute("orders", orders);
        return "/consumer/order";
    }

    @GetMapping("/consumer/cart/buy/{pId}")
    public String buyProduct(@PathVariable("pId") Integer PId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        Order order = new Order();
        order.setUserId(userId); order.setProductId(PId); order.setCreatedAt(LocalDateTime.now()); order.setDestination(user.getDestination());
        orderService.buyProduct(userId, PId, order);
        return "redirect:/consumer/order";
    }

    @PostMapping("/consumer/order/delete/{pId}")
    public String deleteOrder(@PathVariable("pId") Integer PId, HttpSession session) {
        User user = (User) session.getAttribute("user");
        Integer userId = user.getId();
        Order order = orderService.findOrderByTwoId(userId, PId);
        LocalDateTime nowTime = LocalDateTime.now();
        Duration between = Duration.between(order.getCreatedAt(), nowTime);
        long hours = between.toHours();
        if (hours < 24) {
            orderService.deleteOrder(order);
        }
        return "redirect:/consumer/order";
    }
}
