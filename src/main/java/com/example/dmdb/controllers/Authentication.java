package com.example.dmdb.controllers;

import com.example.dmdb.dtos.RegisterDTO;
import com.example.dmdb.users.User;
import com.example.dmdb.users.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class Authentication {

    private final UserService service;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/login")
    public String showLoginPage() {
        return "loginPage";
    }

    @PostMapping("/")
    public String login() {
        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout() {
        return "redirect:/login";
    }

    @GetMapping("/register")
    public String showRegisterPage() {
        return "registerPage";
    }

    @PostMapping("/register")
    public String register(RegisterDTO registerDTO, RedirectAttributes ra) {
        Optional<User> optUSer = service.findByUsername(registerDTO.username());

        if (optUSer.isPresent()) {
            ra.addFlashAttribute("userExists", true);

            return "redirect:/register";
        } else {
            service.createAndSave(registerDTO.username(), passwordEncoder.encode(registerDTO.password()));

            return "redirect:/login";
        }
    }
}
