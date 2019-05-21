package com.ivans.webshop.controllers;

import com.ivans.webshop.dto.UserDTO;
import com.ivans.webshop.repository.entity.AccountEntity;
import com.ivans.webshop.repository.entity.UserEntity;
import com.ivans.webshop.repository.entity.WebUserEntity;
import com.ivans.webshop.repository.enums.UserState;
import com.ivans.webshop.services.AccountService;
import com.ivans.webshop.services.UserService;
import com.ivans.webshop.util.ShoppingCart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AccountService accountService;

    @GetMapping(value = "/users")
    public List<UserDTO> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(value = "/users/{id}")
    public UserDTO getUserById(@PathVariable Integer id) throws Exception {
        return userService.getUserById(id);
    }

    @PostMapping(value = "/users/register")
    public void addUser(@RequestParam String username, @RequestParam String firstName, @RequestParam String lastName, @RequestParam String email, @RequestParam String password, HttpServletResponse httpResponse, HttpServletRequest httpRequest) throws IOException {
        try {

//            Registering user
            WebUserEntity webUser = new WebUserEntity(firstName, lastName, username, password, UserState.New);
            webUser = (WebUserEntity) userService.addUser(webUser);

//            Creating account for newly registered user
            AccountEntity account = new AccountEntity();
            account.setUser(webUser);
            account.setName(webUser.getUsername());
            account = accountService.saveAccount(account);

//            Creating shopping cart for new registered user who is now logged int
            ShoppingCart shoppingCart = new ShoppingCart();

//            Setting account, user and shopping cart into session
            httpRequest.getSession().setAttribute("loggedUser", webUser);
            httpRequest.getSession().setAttribute("cart", shoppingCart);
            httpRequest.getSession().setAttribute("account", account);

            httpResponse.sendRedirect("/");

        } catch (Exception e) {
                e.printStackTrace();
                httpResponse.sendRedirect("/error");
        }
    }

    @PostMapping(value = "/users/login")
    public UserDTO loginUser(@RequestParam String username, @RequestParam String password, HttpServletResponse httpResponse, HttpServletRequest httpRequest) throws IOException {
        try {
//          Searching for user by username and then checking his password
            UserEntity user = userService.getUserByUsername(username, "null");
            if(!user.getPassword().equals(password)){
                throw new Exception("Invalid password!");
            }
//            If the user is successfully authenticated, generate a shopping cart and set both him and the cart into the active session
            AccountEntity account = accountService.getAccountByUsername(user.getUsername(), null);
            ShoppingCart shoppingCart = new ShoppingCart();
            httpRequest.getSession().setAttribute("loggedUser", user);
            httpRequest.getSession().setAttribute("cart", shoppingCart);
            httpRequest.getSession().setAttribute("account", account);
//          Redirect to home page
            httpResponse.sendRedirect("/");
        } catch (Exception e) {
            e.printStackTrace();
            httpResponse.sendRedirect("/error");
        }
        return null;
    }

    @GetMapping(value = "/users/logout")
    public void logoutUser(HttpServletResponse response, HttpServletRequest request){
        System.out.println(request.getSession().getAttribute("loggedUser"));
        request.getSession().removeAttribute("loggedUser");
        request.getSession().removeAttribute("cart");

//        Persisting changes to the account - STILL TO DO (Proveri jos da li ces morati)
        request.getSession().removeAttribute("account");
        try {
            response.sendRedirect("/");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @PutMapping(value = "/users/{id}")
    public void updateUser(@RequestBody UserEntity user, @PathVariable Integer id) throws Exception {
         userService.updateUser(user, id);
    }

    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable Integer id) throws Exception {
         userService.deleteUser(id);
    }
}
