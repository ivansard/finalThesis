package com.ivans.webshop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ApplicationController {

    @RequestMapping("/")
    public String homepage(){
        return "home";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register(){
        return "register";
    }

    @RequestMapping("/profile")
    public String profile(HttpServletRequest request){
        if(request.getSession().getAttribute("loggedUser") != null){
            return "profile";
        }
        return "home";
    }

    @RequestMapping("/paymentDetails")
    public String profilePaymentDetails(HttpServletRequest request){
        if(request.getSession().getAttribute("loggedUser") != null){
            return "paymentDetails";
        }
        return "home";
    }

    @RequestMapping("/shop")
    public String renderShopPage(){
        return "shop";
    }


}
