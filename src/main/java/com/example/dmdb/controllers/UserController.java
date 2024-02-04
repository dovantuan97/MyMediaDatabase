package com.example.dmdb.controllers;

import com.example.dmdb.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/users/{id}")
    public String showUserInfo(@PathVariable Long id, Model model) {
        model.addAttribute("user", userService.findById(id));

        return "userInfo";
    }
}
