package com.example.mall.controller;

import com.example.mall.pojo.User;
import com.example.mall.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class RegisterAndLogInController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam Integer role, Model model) {
        User user = new User();
        user.setUsername(username); user.setPassword(password); user.setRole(role);
        if (userService.registerUser(user)) {
            model.addAttribute("message", "register success");
        }
        else {
            model.addAttribute("message", "username is already in use");
        }
        return "register";
    }

    @PostMapping("/login")
    public String logIn(@RequestParam String username, @RequestParam String password, @RequestParam Integer role, RedirectAttributes redirectAttributes, HttpSession session) {
        User user = userService.findUserByNameAndPwd(username, password);
        if (user != null) {
            session.setAttribute("user", user);
            if (role == 0)
                return "redirect:/merchant/home";
            else
                return "redirect:/consumer/home";
        } else {
            //FlashAttributes可以在重定向期间临时存储和传递属性。
            redirectAttributes.addFlashAttribute("message", "username or password is incorrect");
            return "redirect:/login";
        }
    }

    @GetMapping("/logout")
    public String logOut(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/login";
    }

}
