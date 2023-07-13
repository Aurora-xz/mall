package com.example.mall.controller.consumer;

import com.example.mall.pojo.Cart;
import com.example.mall.pojo.Product;
import com.example.mall.pojo.User;
import com.example.mall.service.CartService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CartController {
    @Autowired
    private CartService cartService;

    @GetMapping("/consumer/cart")
    public String getCart(Model model, HttpSession session) {
        User user = (User)session.getAttribute("user");
        Integer userId = user.getId();
        List<Product> products = cartService.getProductsInCartByUserId(userId);
        model.addAttribute("products", products);
        return "consumer/cart";
    }

    @GetMapping("/consumer/cart/{productId}")
    public String addProductToCart(@PathVariable("productId") Integer PId, HttpSession session) {
        User user = (User)session.getAttribute("user");
        Integer userId = user.getId();
        cartService.addCart(userId, PId);
        return "redirect:/consumer/products";
    }

    @PostMapping("/consumer/cart/delete/{productId}")
    public String deleteProductFromCart(@PathVariable("productId") Integer Pid, HttpSession session) {
        User user = (User)session.getAttribute("user");
        Integer userId = user.getId();
        cartService.deleteCart(userId, Pid);
        return "redirect:/consumer/cart";
    }
}
