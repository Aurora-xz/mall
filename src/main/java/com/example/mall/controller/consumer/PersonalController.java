package com.example.mall.controller.consumer;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PersonalController {

    @GetMapping("/consumer/personal")
    public String personal() {
        return "consumer/person";
    }
}
