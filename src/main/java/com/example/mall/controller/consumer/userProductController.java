package com.example.mall.controller.consumer;


import com.example.mall.pojo.Product;
import com.example.mall.service.ProductService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class userProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/consumer/home")
    public String home() {
        return "consumer/home";
    }

    @GetMapping("/consumer/products")
    public String browseAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "consumer/products";
    }

    @GetMapping("/consumer/details/{id}")
    public String getDetails(@PathVariable("id") Integer id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "consumer/details";
    }

}
