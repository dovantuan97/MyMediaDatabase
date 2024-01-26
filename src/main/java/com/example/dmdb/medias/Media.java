package com.example.dmdb.medias;

import com.example.dmdb.enums.CountryOfOrigin;
import com.example.dmdb.enums.Genre;
import com.example.dmdb.enums.MediaType;
import com.example.dmdb.my_entries.MyEntry;
import com.example.dmdb.roles.Role;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Media {

    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Integer releaseYear;
    private MediaType mediaType;
    private String synopsis;
    private String imageSource;
    @ElementCollection(targetClass = CountryOfOrigin.class)
    @Enumerated(EnumType.STRING)
    private List<CountryOfOrigin> countriesOfOrigin = new ArrayList<>();
    @ElementCollection(targetClass = Genre.class)
    @Enumerated(EnumType.STRING)
    private List<Genre> genres = new ArrayList<>();
    @OneToMany (mappedBy = "media", cascade = CascadeType.ALL)
    private List<Role> roles;
    @OneToMany (mappedBy = "media", cascade = CascadeType.ALL)
    private List<MyEntry> myEntries;

    public float getRating() {
        double avg = myEntries.stream()
                .filter(mE -> mE.getRating() != null)
                .mapToDouble(MyEntry::getRating)
                .average()
                .orElse(0.0);

        return (float) (Math.round(avg * 100.0) / 100.0);
    }
}
