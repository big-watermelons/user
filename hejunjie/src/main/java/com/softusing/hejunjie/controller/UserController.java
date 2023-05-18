package com.softusing.hejunjie.controller;


import com.softusing.hejunjie.form.UserForm;

import com.softusing.hejunjie.server.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userForm",new UserForm());
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }


    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result) {

        if (!userForm.confirmPassword()) {
            result.rejectValue("confirmPassword", "confirmError", "两次密码不一致");
        }
        if (result.hasErrors()) {
            return "register";
        }

//        if (result.hasErrors()) {
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            for (FieldError error : fieldErrors) {
//                System.out.println(error.getField() + " : " + error.getDefaultMessage() + " : " + error.getCode());
//            }
//            boo = false;
//        }
//
//        if (!boo) {
//            return "register";
//        }
        User user = userForm.convertToUser();
        userService.save(user);
        return "redirect:/login";
    }
//
//    public String register(@RequestParam String username,
//                           @RequestParam String password,
//                           @RequestParam String email,
//                           @RequestParam int phone) {
//        User user = new User();
//        user.setUsername(user.getUsername());
//        user.setPassword(user.getPassword());
//        user.setPhone(user.getPhone());
//        user.setEmail(user.getEmail());
//
//        return "redirect:/login";


    @GetMapping("/exception")
    public String testException(){
        throw new RuntimeException();
    }

}




