package com.example.dmdb;

import com.example.dmdb.enums.*;
import com.example.dmdb.actors.Actor;
import com.example.dmdb.medias.Media;
import com.example.dmdb.roles.Role;
import com.example.dmdb.actors.ActorRepo;
import com.example.dmdb.medias.MediaRepo;
import com.example.dmdb.roles.RoleRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DMDBApplication implements CommandLineRunner {

    private final MediaRepo mediaRepo;
    private final ActorRepo actorRepo;
    private final RoleRepo roleRepo;

    public DMDBApplication(MediaRepo mediaRepo, ActorRepo actorRepo, RoleRepo roleRepo) {
        this.mediaRepo = mediaRepo;
        this.actorRepo = actorRepo;
        this.roleRepo = roleRepo;
    }

    public static void main(String[] args) {
        SpringApplication.run(DMDBApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        Media media1 = new Media();
        media1.setMediaType(MediaType.TV_Series);
        media1.getCountriesOfOrigin().add(CountryOfOrigin.KR);
        media1.setTitle("My Name");
        media1.setImageSource("my_name");
        media1.setReleaseYear(2021);
        media1.setEpisodes(16);
        media1.getGenres().add(Genre.Action);
        media1.getGenres().add(Genre.Thriller);
        media1.getGenres().add(Genre.Mystery);
        media1.getGenres().add(Genre.Crime);

        Media media2 = new Media();
        media2.setMediaType(MediaType.Movie);
        media2.setTitle("Kimi no Na wa");
        media2.setImageSource("kimi_no_na_wa");
        media2.getCountriesOfOrigin().add(CountryOfOrigin.JP);
        media2.setReleaseYear(2016);
        media2.setEpisodes(1);
        media2.getGenres().add(Genre.Drama);
        media2.getGenres().add(Genre.Supernatural);

        Media media3 = new Media();
        media3.setMediaType(MediaType.Movie);
        media3.setTitle("Past Lives");
        media3.setImageSource("past_lives");
        media3.getCountriesOfOrigin().add(CountryOfOrigin.KR);
        media3.getCountriesOfOrigin().add(CountryOfOrigin.US);
        media3.setReleaseYear(2023);
        media3.setEpisodes(1);
        media3.getGenres().add(Genre.Romance);
        media3.getGenres().add(Genre.Drama);

        Media media4 = new Media();
        media4.setMediaType(MediaType.TV_Series);
        media4.setTitle("My Demon");
        media4.setImageSource("my_demon");
        media4.getCountriesOfOrigin().add(CountryOfOrigin.KR);
        media4.setReleaseYear(2023);
        media4.setEpisodes(16);
        media4.getGenres().add(Genre.Action);
        media4.getGenres().add(Genre.Comedy);
        media4.getGenres().add(Genre.Romance);
        media4.getGenres().add(Genre.Supernatural);

        Media media5 = new Media();
        media5.setMediaType(MediaType.TV_Series);
        media5.setTitle("Love to Hate You");
        media5.setImageSource("love_to_hate_you");
        media5.getCountriesOfOrigin().add(CountryOfOrigin.KR);
        media5.setReleaseYear(2023);
        media5.setEpisodes(10);
        media5.getGenres().add(Genre.Comedy);
        media5.getGenres().add(Genre.Romance);
        media5.getGenres().add(Genre.Legal);



        Media media6 = new Media();
        media6.setMediaType(MediaType.TV_Series);
        media6.setTitle("Nevertheless,");
        media6.setImageSource("nevertheless,");
        media6.getCountriesOfOrigin().add(CountryOfOrigin.KR);
        media6.setReleaseYear(2021);
        media6.setEpisodes(16);
        media6.getGenres().add(Genre.Romance);
        media6.getGenres().add(Genre.Slice_of_Life);
        media6.getGenres().add(Genre.Drama);

        mediaRepo.save(media1);
        mediaRepo.save(media2);
        mediaRepo.save(media3);
        mediaRepo.save(media4);
        mediaRepo.save(media5);
        mediaRepo.save(media6);

        Actor actor = new Actor("Han So Hee");
        actor.setImageSource("han_so_hee");
        Actor actor1 = new Actor("Yoo Teo");
        actor1.setImageSource("yoo_teo");
        Actor actor2 = new Actor("Song Kang");
        actor2.setImageSource("song_kang");

        actorRepo.save(actor);
        actorRepo.save(actor1);
        actorRepo.save(actor2);

        Role role = new Role();
        role.setActor(actor);
        role.setCharacterName("Yoo Na Bi");
        role.setRoleType(RoleType.Main);
        role.setMedia(media1);

        Role role1 = new Role();
        role1.setActor(actor);
        role1.setRoleType(RoleType.Main);
        role1.setMedia(media6);

        Role role2 = new Role();
        role2.setActor(actor1);
        role2.setRoleType(RoleType.Main);
        role2.setMedia(media5);

        Role role3 = new Role();
        role3.setActor(actor1);
        role3.setRoleType(RoleType.Main);
        role3.setMedia(media3);

        Role role4 = new Role();
        role4.setActor(actor2);
        role4.setRoleType(RoleType.Main);
        role4.setMedia(media6);

        Role role5 = new Role();
        role5.setActor(actor2);
        role5.setRoleType(RoleType.Main);
        role5.setMedia(media4);

        roleRepo.save(role);
        roleRepo.save(role1);
        roleRepo.save(role2);
        roleRepo.save(role3);
        roleRepo.save(role4);
        roleRepo.save(role5);
    }
}
