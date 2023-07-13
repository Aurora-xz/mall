package com.example.mall.controller.merchant;

import com.example.mall.pojo.Product;
import com.example.mall.pojo.User;
import com.example.mall.service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/merchant/home")
    public String merchantHome() {
        return "merchant/home";
    }


    @GetMapping("/merchant/products")
    public String getAllProducts(Model model) {
        List<Product> products = productService.getAllProducts();
        model.addAttribute("products", products);
        return "merchant/products";
    }

    @GetMapping("/merchant/addProduct")
    public String toAddProduct() {
        return "merchant/addProduct";
    }

    @PostMapping("/merchant/addProduct")
    public String addProduct(Product product, HttpSession session) {
        User user = (User)session.getAttribute("user");
        product.setFactory(user.getUsername());
        productService.addProduct(product);
        return "redirect:/merchant/products";
    }

    @GetMapping("/merchant/updateProduct/{id}")
    public String toUpdate(@PathVariable("id") Integer id, Model model) {
        Product product = productService.getProductById(id);
        model.addAttribute("product", product);
        return "/merchant/updateProduct";
    }

    @PostMapping("/merchant/updateProduct")
    public String updateProduct(Product product) {
        productService.updateProduct(product);
        return "redirect:/merchant/products";
    }

    @PostMapping("/merchant/deleteProduct/{id}")
    public String deleteProduct(@PathVariable("id") Integer id) {
        productService.deleteById(id);
        return "redirect:/merchant/products";
    }

}
