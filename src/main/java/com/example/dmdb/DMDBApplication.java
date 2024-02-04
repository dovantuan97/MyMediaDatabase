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
//        Media media1 = new Media();
//        media1.setMediaType(MediaType.TV_Series);
//        media1.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media1.setTitle("My Name");
//        media1.setImageSource("my_name");
//        media1.setReleaseYear(2021);
//        media1.setEpisodes(8);
//        media1.getGenres().add(Genre.Action);
//        media1.getGenres().add(Genre.Thriller);
//        media1.getGenres().add(Genre.Mystery);
//        media1.getGenres().add(Genre.Crime);
//
//        Media media2 = new Media();
//        media2.setMediaType(MediaType.Movie);
//        media2.setTitle("Kimi no Na wa");
//        media2.setImageSource("kimi_no_na_wa");
//        media2.getCountriesOfOrigin().add(CountryOfOrigin.JP);
//        media2.setReleaseYear(2016);
//        media2.setEpisodes(1);
//        media2.getGenres().add(Genre.Drama);
//        media2.getGenres().add(Genre.Supernatural);
//
//        Media media3 = new Media();
//        media3.setMediaType(MediaType.Movie);
//        media3.setTitle("Past Lives");
//        media3.setImageSource("past_lives");
//        media3.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media3.getCountriesOfOrigin().add(CountryOfOrigin.US);
//        media3.setReleaseYear(2023);
//        media3.setEpisodes(1);
//        media3.getGenres().add(Genre.Romance);
//        media3.getGenres().add(Genre.Drama);
//
//        Media media4 = new Media();
//        media4.setMediaType(MediaType.TV_Series);
//        media4.setTitle("My Demon");
//        media4.setImageSource("my_demon");
//        media4.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media4.setReleaseYear(2023);
//        media4.setEpisodes(16);
//        media4.getGenres().add(Genre.Action);
//        media4.getGenres().add(Genre.Comedy);
//        media4.getGenres().add(Genre.Romance);
//        media4.getGenres().add(Genre.Supernatural);
//
//        Media media5 = new Media();
//        media5.setMediaType(MediaType.TV_Series);
//        media5.setTitle("Love to Hate You");
//        media5.setImageSource("love_to_hate_you");
//        media5.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media5.setReleaseYear(2023);
//        media5.setEpisodes(10);
//        media5.getGenres().add(Genre.Comedy);
//        media5.getGenres().add(Genre.Romance);
//        media5.getGenres().add(Genre.Legal);
//
//        Media media6 = new Media();
//        media6.setMediaType(MediaType.TV_Series);
//        media6.setTitle("Nevertheless,");
//        media6.setImageSource("nevertheless,");
//        media6.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media6.setReleaseYear(2021);
//        media6.setEpisodes(16);
//        media6.getGenres().add(Genre.Romance);
//        media6.getGenres().add(Genre.Slice_of_Life);
//        media6.getGenres().add(Genre.Drama);
//
//        Media media7 = new Media();
//        media7.setMediaType(MediaType.Movie);
//        media7.setTitle("20th Century Girl");
//        media7.setImageSource("20th_century_girl");
//        media7.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media7.setReleaseYear(2021);
//        media7.setEpisodes(1);
//        media7.getGenres().add(Genre.Romance);
//        media7.getGenres().add(Genre.School);
//        media7.getGenres().add(Genre.Melodrama);
//
//        Media media8 = new Media();
//        media8.setMediaType(MediaType.TV_Series);
//        media8.setTitle("Call It Love");
//        media8.setImageSource("call_it_love");
//        media8.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media8.setReleaseYear(2023);
//        media8.setEpisodes(16);
//        media8.getGenres().add(Genre.Romance);
//        media8.getGenres().add(Genre.Drama);
//        media8.getGenres().add(Genre.Melodrama);
//
//        Media media9 = new Media();
//        media9.setMediaType(MediaType.TV_Series);
//        media9.setTitle("Celebrity");
//        media9.setImageSource("celebrity");
//        media9.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media9.setReleaseYear(2023);
//        media9.setEpisodes(12);
//        media9.getGenres().add(Genre.Romance);
//        media9.getGenres().add(Genre.Drama);
//        media9.getGenres().add(Genre.Melodrama);
//
//        Media media10 = new Media();
//        media10.setMediaType(MediaType.TV_Series);
//        media10.setTitle("Death's Game");
//        media10.setImageSource("deaths_game");
//        media10.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media10.setReleaseYear(2023);
//        media10.setEpisodes(8);
//        media10.getGenres().add(Genre.Romance);
//        media10.getGenres().add(Genre.Drama);
//        media10.getGenres().add(Genre.Melodrama);
//
//        Media media11 = new Media();
//        media11.setMediaType(MediaType.TV_Series);
//        media11.setTitle("Doona!");
//        media11.setImageSource("doona");
//        media11.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media11.setReleaseYear(2023);
//        media11.setEpisodes(9);
//        media11.getGenres().add(Genre.Romance);
//        media11.getGenres().add(Genre.Drama);
//
//        Media media12 = new Media();
//        media12.setMediaType(MediaType.TV_Series);
//        media12.setTitle("Heartbeat");
//        media12.setImageSource("heartbeat");
//        media12.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media12.setReleaseYear(2023);
//        media12.setEpisodes(16);
//        media12.getGenres().add(Genre.Romance);
//        media12.getGenres().add(Genre.Comedy);
//        media12.getGenres().add(Genre.Supernatural);
//
//        Media media13 = new Media();
//        media13.setMediaType(MediaType.TV_Series);
//        media13.setTitle("Lies Hidden in My Garden");
//        media13.setImageSource("lies_hidden_in_my_garden");
//        media13.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media13.setReleaseYear(2023);
//        media13.setEpisodes(8);
//        media13.getGenres().add(Genre.Thriller);
//        media13.getGenres().add(Genre.Mystery);
//        media13.getGenres().add(Genre.Psychological);
//        media13.getGenres().add(Genre.Drama);
//
//        Media media14 = new Media();
//        media14.setMediaType(MediaType.TV_Series);
//        media14.setTitle("Moving");
//        media14.setImageSource("moving");
//        media14.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media14.setReleaseYear(2023);
//        media14.setEpisodes(20);
//        media14.getGenres().add(Genre.Thriller);
//        media14.getGenres().add(Genre.Action);
//        media14.getGenres().add(Genre.Mystery);
//        media14.getGenres().add(Genre.Supernatural);
//
//        Media media15 = new Media();
//        media15.setMediaType(MediaType.TV_Series);
//        media15.setTitle("Revenant");
//        media15.setImageSource("revenant");
//        media15.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media15.setReleaseYear(2023);
//        media15.setEpisodes(12);
//        media15.getGenres().add(Genre.Thriller);
//        media15.getGenres().add(Genre.Horror);
//        media15.getGenres().add(Genre.Mystery);
//        media15.getGenres().add(Genre.Supernatural);
//
//        Media media16 = new Media();
//        media16.setMediaType(MediaType.TV_Series);
//        media16.setTitle("Snowdrop");
//        media16.setImageSource("snowdrop");
//        media16.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media16.setReleaseYear(2021);
//        media16.setEpisodes(16);
//        media16.getGenres().add(Genre.Romance);
//        media16.getGenres().add(Genre.Drama);
//        media16.getGenres().add(Genre.Melodrama);
//        media16.getGenres().add(Genre.School);
//
//        Media media17 = new Media();
//        media17.setMediaType(MediaType.TV_Series);
//        media17.setTitle("The Glory");
//        media17.setImageSource("the_glory");
//        media17.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media17.setReleaseYear(2022);
//        media17.setEpisodes(16);
//        media17.getGenres().add(Genre.Thriller);
//        media17.getGenres().add(Genre.Drama);
//        media17.getGenres().add(Genre.Melodrama);
//
//        Media media18 = new Media();
//        media18.setMediaType(MediaType.TV_Series);
//        media18.setTitle("The Killing Vote");
//        media18.setImageSource("the_killing_vote");
//        media18.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media18.setReleaseYear(2023);
//        media18.setEpisodes(12);
//        media18.getGenres().add(Genre.Thriller);
//        media18.getGenres().add(Genre.Horror);
//        media18.getGenres().add(Genre.Mystery);
//
//        Media media19 = new Media();
//        media19.setMediaType(MediaType.TV_Series);
//        media19.setTitle("Twinkling Watermelon");
//        media19.setImageSource("twinkling_watermelon");
//        media19.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media19.setReleaseYear(2023);
//        media19.setEpisodes(16);
//        media19.getGenres().add(Genre.Romance);
//        media19.getGenres().add(Genre.School);
//        media19.getGenres().add(Genre.Drama);
//        media19.getGenres().add(Genre.Supernatural);
//
//        Media media20 = new Media();
//        media20.setMediaType(MediaType.TV_Series);
//        media20.setTitle("A Business Proposal");
//        media20.setImageSource("a_business_proposal");
//        media20.getCountriesOfOrigin().add(CountryOfOrigin.KR);
//        media20.setReleaseYear(2022);
//        media20.setEpisodes(16);
//        media20.getGenres().add(Genre.Comedy);
//        media20.getGenres().add(Genre.Romance);
//        media20.getGenres().add(Genre.Drama);
//
//        mediaRepo.save(media1);
//        mediaRepo.save(media2);
//        mediaRepo.save(media3);
//        mediaRepo.save(media4);
//        mediaRepo.save(media5);
//        mediaRepo.save(media6);
//        mediaRepo.save(media7);
//        mediaRepo.save(media8);
//        mediaRepo.save(media9);
//        mediaRepo.save(media10);
//        mediaRepo.save(media11);
//        mediaRepo.save(media12);
//        mediaRepo.save(media13);
//        mediaRepo.save(media14);
//        mediaRepo.save(media15);
//        mediaRepo.save(media16);
//        mediaRepo.save(media17);
//        mediaRepo.save(media18);
//        mediaRepo.save(media19);
//        mediaRepo.save(media20);
//
//
//        Actor actor = new Actor("Han So Hee");
//        actor.setImageSource("han_so_hee");
//        Actor actor1 = new Actor("Yoo Teo");
//        actor1.setImageSource("yoo_teo");
//        Actor actor2 = new Actor("Song Kang");
//        actor2.setImageSource("song_kang");
//        Actor actor3 = new Actor("Bae Suzy");
//        actor3.setImageSource("bae_suzy");
//        Actor actor4 = new Actor("Bona");
//        actor4.setImageSource("bona");
//        Actor actor5 = new Actor("Go Woon Hee");
//        actor5.setImageSource("go_woon_hee");
//        Actor actor6 = new Actor("Go Youn Jung");
//        actor6.setImageSource("go_youn_jung");
//        Actor actor7 = new Actor("Han Hyo Joo");
//        actor7.setImageSource("han_hyo_joo");
//        Actor actor8 = new Actor("Jung Shin Hye");
//        actor8.setImageSource("jung_shin_hye");
//        Actor actor9 = new Actor("Seol In Ah");
//        actor9.setImageSource("seol_in_ah");
//        Actor actor10 = new Actor("Kim Ji Soo");
//        actor10.setImageSource("kim_ji_soo");
//        Actor actor11 = new Actor("Lim Ji Yeon");
//        actor11.setImageSource("lim_ji_yeon");
//
//        actorRepo.save(actor);
//        actorRepo.save(actor1);
//        actorRepo.save(actor2);
//        actorRepo.save(actor3);
//        actorRepo.save(actor4);
//        actorRepo.save(actor5);
//        actorRepo.save(actor6);
//        actorRepo.save(actor7);
//        actorRepo.save(actor8);
//        actorRepo.save(actor9);
//        actorRepo.save(actor10);
//        actorRepo.save(actor11);
//
//        Role role = new Role();
//        role.setActor(actor);
//        role.setRoleType(RoleType.Main);
//        role.setMedia(media1);
//
//        Role role1 = new Role();
//        role1.setActor(actor);
//        role1.setRoleType(RoleType.Main);
//        role1.setMedia(media6);
//
//        Role role2 = new Role();
//        role2.setActor(actor1);
//        role2.setRoleType(RoleType.Main);
//        role2.setMedia(media5);
//
//        Role role3 = new Role();
//        role3.setActor(actor1);
//        role3.setRoleType(RoleType.Main);
//        role3.setMedia(media3);
//
//        Role role4 = new Role();
//        role4.setActor(actor2);
//        role4.setRoleType(RoleType.Main);
//        role4.setMedia(media6);
//
//        Role role5 = new Role();
//        role5.setActor(actor2);
//        role5.setRoleType(RoleType.Main);
//        role5.setMedia(media4);
//
//        Role role6 = new Role();
//        role6.setActor(actor3);
//        role6.setRoleType(RoleType.Main);
//        role6.setMedia(media11);
//
//        Role role7 = new Role();
//        role7.setActor(actor5);
//        role7.setRoleType(RoleType.Main);
//        role7.setMedia(media5);
//
//        Role role8 = new Role();
//        role8.setActor(actor6);
//        role8.setRoleType(RoleType.Main);
//        role8.setMedia(media14);
//
//        Role role9 = new Role();
//        role9.setActor(actor7);
//        role9.setRoleType(RoleType.Main);
//        role9.setMedia(media14);
//
//        Role role10 = new Role();
//        role10.setActor(actor8);
//        role10.setRoleType(RoleType.Support);
//        role10.setMedia(media16);
//
//        Role role11 = new Role();
//        role11.setActor(actor9);
//        role11.setRoleType(RoleType.Main);
//        role11.setMedia(media19);
//
//        Role role12 = new Role();
//        role12.setActor(actor9);
//        role12.setRoleType(RoleType.Main);
//        role12.setMedia(media20);
//
//        Role role13 = new Role();
//        role13.setActor(actor10);
//        role13.setRoleType(RoleType.Main);
//        role13.setMedia(media16);
//
//        Role role14 = new Role();
//        role14.setActor(actor11);
//        role14.setRoleType(RoleType.Main);
//        role14.setMedia(media13);
//
//        Role role15 = new Role();
//        role15.setActor(actor11);
//        role15.setRoleType(RoleType.Main);
//        role15.setMedia(media17);
//
//        Role role16 = new Role();
//        role16.setActor(actor11);
//        role16.setRoleType(RoleType.Main);
//        role16.setMedia(media18);
//
//        Role role17 = new Role();
//        role17.setActor(actor6);
//        role17.setRoleType(RoleType.Main);
//        role17.setMedia(media10);
//
//        roleRepo.save(role);
//        roleRepo.save(role1);
//        roleRepo.save(role2);
//        roleRepo.save(role3);
//        roleRepo.save(role4);
//        roleRepo.save(role5);
//        roleRepo.save(role6);
//        roleRepo.save(role7);
//        roleRepo.save(role8);
//        roleRepo.save(role9);
//        roleRepo.save(role10);
//        roleRepo.save(role11);
//        roleRepo.save(role12);
//        roleRepo.save(role13);
//        roleRepo.save(role14);
//        roleRepo.save(role15);
//        roleRepo.save(role16);
//        roleRepo.save(role17);
    }
}
