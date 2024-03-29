package com.example.dmdb.controllers;

import com.example.dmdb.enums.CountryOfOrigin;
import com.example.dmdb.enums.Genre;
import com.example.dmdb.enums.MediaType;
import com.example.dmdb.enums.Status;
import com.example.dmdb.medias.Media;
import com.example.dmdb.medias.MediaService;
import com.example.dmdb.my_entries.MyEntryService;
import com.example.dmdb.users.User;
import com.example.dmdb.users.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class EntryController {

    private final MyEntryService entryService;
    private final UserService userService;
    private final MediaService mediaService;

    @GetMapping("/")
    public String showMainPage(Model model, Principal principal) {
        model.addAttribute("entries", getUser(principal).getMyEntries());

        return "mainPage";
    }

    @PostMapping("/entry/add")
    public String addToList(Principal principal, Long mediaId, Status status, Float rating) {
        entryService.addToList(getUser(principal), getMedia(mediaId), status, rating);

        return "redirect:/medias";
    }

    @GetMapping("/entries/filterYear/{year}")
    public String filterEntryYear(@PathVariable Integer year, Model model, Principal principal) {
        model.addAttribute("entries", entryService.findAllByReleaseYear(getUser(principal), year));

        return "mainPage";
    }

    @GetMapping("/entries/filterCountry/{countryOfOrigin}")
    public String filterEntryCountry(@PathVariable CountryOfOrigin countryOfOrigin, Model model, Principal principal) {
        model.addAttribute("entries", entryService.findAllByCountryOfOrigin(getUser(principal), countryOfOrigin));

        return "mainPage";
    }

    @GetMapping("/entries/filterType/{mediaType}")
    public String filterEntryType(@PathVariable MediaType mediaType, Model model, Principal principal) {
        model.addAttribute("entries", entryService.findAllByMediaType(getUser(principal), mediaType));

        return "mainPage";
    }

    @GetMapping("/entries/filterGenre/{genre}")
    public String filterEntryGenre(@PathVariable Genre genre, Model model, Principal principal) {
        model.addAttribute("entries", entryService.findByUserIdAndGenre(getUser(principal), genre));

        return "mainPage";
    }

    @GetMapping("/entries/filterStatus/{status}")
    public String filterEntryType(@PathVariable Status status, Model model, Principal principal) {
        model.addAttribute("entries", entryService.findByUserIdAndStatus(getUser(principal), status));

        return "mainPage";
    }

    public User getUser(Principal principal) {
        return userService.findByUsername(principal.getName()).orElseThrow(EntityNotFoundException::new);
    }

    public Media getMedia(Long mediaId) {
        return mediaService.findById(mediaId).orElseThrow(EntityNotFoundException::new);
    }
}
