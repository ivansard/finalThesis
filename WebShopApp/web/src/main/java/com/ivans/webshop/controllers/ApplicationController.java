package com.ivans.webshop.controllers;

import com.ivans.webshop.dto.ProductDTO;
import com.ivans.webshop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class ApplicationController {

    @Autowired
    ProductService productService;

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
    public String renderShopPage(HttpServletRequest request){

        List<ProductDTO> allProducts = productService.getAllProducts();
        request.setAttribute("products", allProducts);

        return "shop";
    }


}
