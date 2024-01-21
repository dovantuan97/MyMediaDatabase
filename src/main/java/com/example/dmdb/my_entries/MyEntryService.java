package com.example.dmdb.my_entries;

import com.example.dmdb.enums.CountryOfOrigin;
import com.example.dmdb.enums.Genre;
import com.example.dmdb.enums.MediaType;
import com.example.dmdb.enums.Status;
import com.example.dmdb.medias.Media;
import com.example.dmdb.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class MyEntryService {

    private final MyEntryRepo repo;

    public List<Long> getMyEntriesId(User user) {
        return repo.findAllByUserId(user.getId()).stream()
                .map(e -> e.getMedia().getId())
                .toList();

    }

    public List<MyEntry> findAllByReleaseYear(User user, Integer year) {
        return repo.findAllByUserId(user.getId()).stream()
                .filter(e -> e.getMedia().getReleaseYear().equals(year))
                .toList();
    }

    public List<MyEntry> findAllByCountryOfOrigin(User user, CountryOfOrigin country) {
        return repo.findAllByUserId(user.getId()).stream()
                .filter(e -> e.getMedia().getCountriesOfOrigin().contains(country))
                .toList();
    }

    public List<MyEntry> findAllByMediaType(User user, MediaType type) {
        return repo.findAllByUserId(user.getId()).stream()
                .filter(e -> e.getMedia().getMediaType().equals(type))
                .toList();
    }

    public List<MyEntry> findByUserIdAndGenre(User user, Genre genre) {
        return repo.findAllByUserId(user.getId()).stream()
                .filter(e -> e.getMedia().getGenres().contains(genre))
                .toList();
    }

    public void addToList(User user, Media media, Status status) {
        MyEntry entry = new MyEntry(user, media, status);
        repo.save(entry);
    }

    public Long getRandomEntry(User user) {
        List<Long> mediaIds = repo.findAllByUserIdAndStatus(user.getId(), Status.Plan_to_Watch).stream()
                .map(e -> e.getMedia().getId())
                .toList();
        Random random = new Random();

        return mediaIds.get(random.nextInt(mediaIds.size()));
    }

    public List<MyEntry> findByUserIdAndStatus(User user, Status status) {
        return repo.findAllByUserIdAndStatus(user.getId(), status);
    }
}
