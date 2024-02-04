package com.example.dmdb.controllers;

import com.example.dmdb.actors.Actor;
import com.example.dmdb.enums.*;
import com.example.dmdb.medias.Media;
import com.example.dmdb.actors.ActorService;
import com.example.dmdb.medias.MediaService;
import com.example.dmdb.my_entries.MyEntryService;
import com.example.dmdb.roles.Role;
import com.example.dmdb.roles.RoleService;
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
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final ActorService actorService;
    private final MediaService mediaService;
    private final RoleService roleService;
    private final UserService userService;
    private final MyEntryService myEntryService;

    @PostMapping("/medias/create")
    public String createNewMedia(Media media) {
        mediaService.save(media);

        return "redirect:/medias";
    }

    @GetMapping("/medias")
    public String showDatabase(Model model, Principal principal) {
        List<Long> myEntries= myEntryService.getMyEntriesId(getUser(principal));

        model.addAttribute("myEntries", myEntries);
        model.addAttribute("medias", mediaService.findAll());
        addOptions(model);

        return "database";
    }

    @GetMapping("/medias/filterYear/{year}")
    public String filterDatabaseYear(@PathVariable Integer year, Model model, Principal principal) {
        List<Long> myEntries= myEntryService.getMyEntriesId(getUser(principal));

        model.addAttribute("myEntries", myEntries);
        model.addAttribute("medias", mediaService.findByYear(year));
        addOptions(model);

        return "database";
    }

    @GetMapping("/medias/filterCountry/{countryOfOrigin}")
    public String filterDatabaseCountry(@PathVariable CountryOfOrigin countryOfOrigin, Model model, Principal principal) {
        List<Long> myEntries= myEntryService.getMyEntriesId(getUser(principal));

        model.addAttribute("myEntries", myEntries);
        model.addAttribute("medias", mediaService.findByCountry(countryOfOrigin));
        addOptions(model);

        return "database";
    }

    @GetMapping("/medias/filterType/{mediaType}")
    public String filterDatabaseType(@PathVariable MediaType mediaType, Model model, Principal principal) {
        List<Long> myEntries= myEntryService.getMyEntriesId(getUser(principal));

        model.addAttribute("myEntries", myEntries);
        model.addAttribute("medias", mediaService.findByType(mediaType));
        addOptions(model);

        return "database";
    }

    @GetMapping("/medias/filterGenre/{genre}")
    public String filterDatabaseGenre(@PathVariable Genre genre, Model model, Principal principal) {
        List<Long> myEntries= myEntryService.getMyEntriesId(getUser(principal));

        model.addAttribute("myEntries", myEntries);
        model.addAttribute("medias", mediaService.findByGenre(genre));
        addOptions(model);

        return "database";
    }

    @GetMapping("/medias/{mediaId}")
    public String showMediaInfo(@PathVariable Long mediaId, Model model) {
        Optional<Media> optMedia = mediaService.findById(mediaId);

        if(optMedia.isEmpty()) {
           throw new RuntimeException("Media not found");
        }
        else {
            Media media = optMedia.get();
            List<Role> roles = media.getRoles().stream()
                    .sorted(Comparator.comparing(Role::getRoleType)
                            .thenComparing(r -> r.getActor().getName()))
                            .toList();
            model.addAttribute("media", media);
            model.addAttribute("roles", roles);
            model.addAttribute("roleTypes", RoleType.values());
        }

        return "mediaInfo";
    }

    @PostMapping("/medias/{mediaId}")
    public String addActor(@PathVariable Long mediaId, Role role, String name) {
        Optional<Actor> tempActor = actorService.findByName(name);
        Optional<Media> tempMedia = mediaService.findById(mediaId);

        if(tempActor.isEmpty()) {
            Actor newActor = new Actor(name);
            actorService.save(newActor);
            role.setActor(newActor);
        }
        else if (tempMedia.isPresent()
                && tempMedia.get().getRoles().stream().anyMatch(r -> r.getActor() == tempActor.get())) {
            throw new RuntimeException("Actor already in cast");
        }
        else {
            role.setActor(tempActor.get());
        }
        roleService.save(role);

        return "redirect:/medias/" + mediaId;
    }

    @GetMapping("/actors/{actorId}")
    public String showActorInfo(@PathVariable Long actorId, Model model) {
        Optional<Actor> temp = actorService.findById(actorId);

        if (temp.isEmpty()) {
            throw new RuntimeException("Actor not found");
        }
        else {
            model.addAttribute("actor", temp.get());
            addOptions(model);
        }

        return "actorInfo";
    }

    @GetMapping("/users")
    public String showUsers(Model model, Principal principal) {
        model.addAttribute("users", userService.findOtherUsers(getUser(principal)));

        return "users";
    }

    @GetMapping("/test")
    public String showTestJavaScript() {
        return "testJavaScript";
    }

    public void addOptions(Model model) {
        model.addAttribute("mediaTypeOptions", MediaType.values());
        model.addAttribute("statusOptions", Status.values());
        model.addAttribute("countryOfOriginOptions", CountryOfOrigin.values());
        model.addAttribute("genreOption", Genre.values());
    }

    public User getUser(Principal principal) {
        return userService.findByUsername(principal.getName()).orElseThrow(EntityNotFoundException::new);
    }
}
