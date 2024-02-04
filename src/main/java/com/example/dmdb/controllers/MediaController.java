package com.example.dmdb.controllers;

import com.example.dmdb.medias.Media;
import com.example.dmdb.medias.MediaService;
import com.example.dmdb.users.User;
import com.example.dmdb.users.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;
    private final UserService userService;

    @PostMapping("/medias/create")
    public String createNewMedia(Media media) {
        mediaService.save(media);

        return "redirect:/medias";
    }

    @GetMapping("/medias/random")
    public String getRandom(Principal principal) {
        return "redirect:/medias/" + mediaService.getRandomMedia(getUser(principal));
    }

    public User getUser(Principal principal) {
        return userService.findByUsername(principal.getName()).orElseThrow(EntityNotFoundException::new);
    }
}
