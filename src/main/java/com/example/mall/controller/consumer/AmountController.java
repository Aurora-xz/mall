package com.example.mall.controller.consumer;

import com.example.mall.pojo.User;
import com.example.mall.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class AmountController {

    @Autowired
    private UserService userService;

    @GetMapping("/consumer/bank")
    public String bank() {
        return "consumer/bank";
    }

    @PostMapping("/consumer/bank/recharge")
    public String recharge(@RequestParam("amount")BigDecimal amount, HttpSession session) {
        User user = (User)session.getAttribute("user");
        user.setAmount(user.getAmount().add(amount));
        userService.updateUserAmount(user);
        return "redirect:/consumer/personal";
    }

    @PostMapping("/consumer/bank/destination")
    public String setDestination(@RequestParam("destination")String destination, HttpSession session) {
        User user = (User)session.getAttribute("user");
        user.setDestination(destination);
        userService.updateUserDestination(user);
        return "redirect:/consumer/personal";
    }
}
