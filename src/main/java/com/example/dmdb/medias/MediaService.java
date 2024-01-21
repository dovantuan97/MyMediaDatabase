package com.example.dmdb.medias;

import com.example.dmdb.enums.CountryOfOrigin;
import com.example.dmdb.enums.Genre;
import com.example.dmdb.enums.MediaType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MediaService {

    private final MediaRepo repo;

    public MediaService(MediaRepo repo) {
        this.repo = repo;
    }

    public List<Media> findAll() {
        return repo.findAll();
    }

    public void save(Media media) {
        Optional<Media> temp = repo.findByTitle(media.getTitle());

        if (temp.isPresent()) {
            media.setImageSource(setImgSource(media) + "_" + media.getReleaseYear());
        }
        else {
            media.setImageSource(setImgSource(media));
        }

        repo.save(media);
    }

    public Optional<Media> findById(Long id) {
        return repo.findById(id);
    }

    public List<Media> findByYear(Integer year) {
        return repo.findAllByReleaseYear(year);
    }

    public List<Media> findByCountry(CountryOfOrigin country) {
        return repo.findAllByCountriesOfOriginContains(country);
    }

    public List<Media> findByType(MediaType type) {
        return repo.findAllByMediaType(type);
    }

//    public List<Media> findByStatus(Status status) {
//        return repo.findAllByStatus(status);
//    }

    public String setImgSource(Media media) {
       return media.getTitle().toLowerCase().replace(" ", "_").replace("'", "");
    }

    public List<Media> findByGenre(Genre genre) {
        return repo.findAllByGenresContains(genre);
    }
}
