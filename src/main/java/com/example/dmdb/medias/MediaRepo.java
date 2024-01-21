package com.example.dmdb.medias;

import com.example.dmdb.enums.CountryOfOrigin;
import com.example.dmdb.enums.Genre;
import com.example.dmdb.enums.MediaType;
import com.example.dmdb.enums.Status;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;
import java.util.Optional;

public interface MediaRepo extends ListCrudRepository<Media, Long> {
    List<Media> findAllByReleaseYear(Integer releaseYear);
    List<Media> findAllByCountriesOfOriginContains(CountryOfOrigin countriesOfOrigin);
    List<Media> findAllByMediaType(MediaType type);
//    List<Media> findAllByStatus(Status status);
    Optional<Media> findByTitle(String title);
    List<Media> findAllByGenresContains(Genre genre);
}
