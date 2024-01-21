package com.example.dmdb.my_entries;

import com.example.dmdb.enums.Status;
import com.example.dmdb.medias.Media;
import com.example.dmdb.users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class MyEntry {

    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    private User user;
    @ManyToOne
    private Media media;
    private Integer Rating;
    private Status status;
    private LocalDate dateStarted;
    private LocalDate dateFinished;

    public MyEntry(User user, Media media, Status status) {
        this.user = user;
        this.media = media;
        this.status = status;
    }
}
