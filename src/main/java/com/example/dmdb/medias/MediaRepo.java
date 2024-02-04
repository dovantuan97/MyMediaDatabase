package com.example.dmdb.medias;

import com.example.dmdb.enums.CountryOfOrigin;
import com.example.dmdb.enums.Genre;
import com.example.dmdb.enums.MediaType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MediaRepo extends JpaRepository<Media, Long> {
    List<Media> findAllByReleaseYear(Integer releaseYear);
    List<Media> findAllByCountriesOfOriginContains(CountryOfOrigin countriesOfOrigin);
    List<Media> findAllByMediaType(MediaType type);
    Optional<Media> findByTitle(String title);
    List<Media> findAllByGenresContains(Genre genre);
}
