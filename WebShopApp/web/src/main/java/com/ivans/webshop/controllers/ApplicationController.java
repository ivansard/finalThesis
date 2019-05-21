package com.ivans.webshop.controllers;

import com.ivans.webshop.dto.LineItemDTO;
import com.ivans.webshop.dto.ProductDTO;
import com.ivans.webshop.dto.UserDTO;
import com.ivans.webshop.repository.entity.*;
import com.ivans.webshop.repository.enums.OrderStatus;
import com.ivans.webshop.services.LineItemService;
import com.ivans.webshop.services.OrderService;
import com.ivans.webshop.services.ProductService;
import com.ivans.webshop.util.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class ApplicationController {

    @Autowired
    ProductService productService;
    @Autowired
    OrderService orderService;
    @Autowired
    LineItemService lineItemService;

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
        UserEntity loggedUser = (UserEntity) session.getAttribute("loggedUser");
        if(loggedUser == null){
            return "checkout";
        } else {
//        Uzeti proizvod i shopping cart iz sesije
            ProductEntity product = productService.getProductById(productId, null);
            ShoppingCart shoppingCart = (ShoppingCart) session.getAttribute("cart");
//        Napravi line-item i dodaj ga u shopping cart
            LineItemEntity lineItem = new LineItemEntity(quantity, quantity * product.getPrice(), product, null);
            shoppingCart.getLineItems().add(lineItem);
//        Izrenderuj checkout sa update-ovanim shopping cartom
            return "checkout";
        }
    }

    @RequestMapping(value = "/placeOrder", method = RequestMethod.POST)
    public String placeOrder(HttpServletResponse response, HttpSession session) throws Exception {
//        Uzeti lineIteme iz carta koji je u sesiji
        ShoppingCart activeCart = (ShoppingCart) session.getAttribute("cart");
        AccountEntity activeAccount = (AccountEntity) session.getAttribute("account");
        System.out.println("ACCOUNT");
        System.out.println(activeAccount);
        List<LineItemEntity> lineItems = activeCart.getLineItems();
        double orderPrice = calculateTotalOrderPrice(lineItems);
//        Napraviti order za te lineIteme
        OrderEntity order = new OrderEntity(new Date(), null, OrderStatus.NEW, orderPrice, activeAccount);
//        Sacuvati order u bazu
        order = orderService.addOrder(order);
//        Staviti order u niz ordera u account koji je u sesiji
        activeAccount.getOrders().add(order);
//        Sacuvati line iteme u bazu
        lineItems = setOrderToLineItems(lineItems, order);
        for (LineItemEntity lineItem: lineItems
        ) {
            lineItemService.addLineItem(lineItem);
        }
//        Vratiti na profile page
        return "profile";
    }

    public static double calculateTotalOrderPrice(List<LineItemEntity> lineItems){
        double sum = 0;
        for (LineItemEntity lineItem: lineItems
             ) {
            sum += lineItem.getTotalPrice();
        }
        return sum;
    }

    public static List<LineItemEntity> setOrderToLineItems(List<LineItemEntity> lineItems, OrderEntity order){
        for (LineItemEntity lineItem: lineItems
        ) {
            lineItem.setOrder(order);
        }
        return lineItems;
    }

}
