package com.example.mall.controller.merchant;

import com.example.mall.pojo.Order;
import com.example.mall.pojo.User;
import com.example.mall.service.OrderService;
import com.example.mall.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderController {
    @Autowired
    private OrderService orderService;

    @Autowired
    private ProductService productService;

    @GetMapping("/merchant/order")
    public String viewOrders(HttpSession session, Model model) {
        User user = (User)session.getAttribute("user");
        String username = user.getUsername();
        List<Integer> pIds = productService.getPIdsByUName(username);
        List<Order> orders = new ArrayList<>();
        for (int pid : pIds) {
            List<Order> orderList = orderService.getOrdersByPid(pid);
            for (Order order : orderList) {
                orders.add(order);
            }
        }
        model.addAttribute("orders", orders);
        return "merchant/orders";
    }

    @GetMapping("/merchant/order/{id}")
    public String toUpdateState(@PathVariable("id") Integer id, Model model) {
        Order order = orderService.getOrderById(id);
        model.addAttribute("order", order);
        return "/merchant/setstate";
    }

    @PostMapping("/merchant/order/setstate")
    public String setState(@RequestParam("id") Integer id, @RequestParam("state") String state) {
        Order order = orderService.getOrderById(id);
        order.setState(state);
        orderService.updateOrder(order);
        return "redirect:/merchant/order";
    }

}
