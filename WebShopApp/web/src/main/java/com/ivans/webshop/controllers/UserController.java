package com.ivans.webshop.controllers;

import com.ivans.webshop.dto.UserDTO;
import com.ivans.webshop.repository.entity.AccountEntity;
import com.ivans.webshop.repository.entity.UserEntity;
import com.ivans.webshop.repository.entity.WebUserEntity;
import com.ivans.webshop.repository.enums.UserState;
import com.ivans.webshop.services.AccountService;
import com.ivans.webshop.services.UserService;
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

            WebUserEntity webUser = new WebUserEntity(firstName, lastName, username, password, UserState.New);
            webUser = (WebUserEntity) userService.addUser(webUser);

            httpRequest.getSession().setAttribute("loggedUser", webUser);
            System.out.println(httpRequest.getSession().getAttribute("loggedUser"));


            AccountEntity account = new AccountEntity();
            account.setUser(webUser);
            account.setName(webUser.getUsername());
            accountService.saveAccount(account);

            httpResponse.sendRedirect("/");

        } catch (Exception e) {
                e.printStackTrace();
                httpResponse.sendRedirect("/error");
        }
    }

    @PostMapping(value = "/users/login")
    public UserDTO loginUser(@RequestParam String username, @RequestParam String password, HttpServletResponse httpResponse, HttpServletRequest httpRequest) throws IOException {
        try {
            System.out.println(username);
            UserDTO user = userService.getUserByUsername(username);
            System.out.println(user.getUsername());
            if(!user.getPassword().equals(password)){
                throw new Exception("Invalid password!");
            }
            httpRequest.getSession().setAttribute("loggedUser", user);
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
