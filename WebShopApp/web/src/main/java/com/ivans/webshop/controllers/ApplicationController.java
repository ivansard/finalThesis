package com.ivans.webshop.controllers;

import com.ivans.webshop.dto.LineItemDTO;
import com.ivans.webshop.dto.ProductDTO;
import com.ivans.webshop.dto.UserDTO;
import com.ivans.webshop.repository.entity.LineItemEntity;
import com.ivans.webshop.services.ProductService;
import com.ivans.webshop.util.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ApplicationController {

    @Autowired
    ProductService productService;

    @RequestMapping("/")
    public String homepage() {
        return "home";
    }

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "register";
    }

    @RequestMapping("/profile")
    public String profile(HttpServletRequest request) {
        if (request.getSession().getAttribute("loggedUser") != null) {
            return "profile";
        }
        return "home";
    }

    @RequestMapping("/paymentDetails")
    public String profilePaymentDetails(HttpServletRequest request) {
        if (request.getSession().getAttribute("loggedUser") != null) {
            return "paymentDetails";
        }
        return "home";
    }

    @RequestMapping("/shop")
    public String renderShopPage(HttpServletRequest request) {

        List<ProductDTO> allProducts = productService.getAllProducts();
        request.setAttribute("products", allProducts);

        return "shop";
    }

    @RequestMapping("/products/{productId}")
    public String renderProductPage(@PathVariable Integer productId, HttpServletRequest request) throws Exception {
        ProductDTO product = productService.getProductById(productId);
        request.setAttribute("product", product);
        return "product";
    }

    @RequestMapping(value = "/checkout", method = RequestMethod.POST)
    public String renderCheckoutPage(@RequestParam("quantity") Integer quantity, @RequestParam("productId") Integer productId, HttpSession session) throws Exception {
        UserDTO loggedUser = (UserDTO) session.getAttribute("loggedUser");
        if(loggedUser == null){
            return "checkout";
        } else {
//        Uzeti proizvod i shopping cart iz sesije
            ProductDTO product = productService.getProductById(productId);
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
//        Napravi line-item i dodaj ga u shopping cart
            LineItemDTO lineItem = new LineItemDTO(quantity, quantity * product.getPrice(), product);
            shoppingCart.getLineItems().add(lineItem);
//        Izrenderuj checkout sa update-ovanim shopping cartom
            return "checkout";
        }
    }


}
