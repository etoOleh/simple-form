package com.simpleform.simpleform.controller;

import com.simpleform.simpleform.model.DateModel;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShopController {

    @GetMapping("/")
    public String getShopPage(){
        return "shop";
    }

    @GetMapping("/order")
    public String getOrder1Page(){
        return "order/order0";
    }

    @GetMapping("/order1")
    public String getOrder2Page(){
        return "order/order1";
    }

    @GetMapping("/app")
    public String getIndexPage(){
        return "app";
    }
}
