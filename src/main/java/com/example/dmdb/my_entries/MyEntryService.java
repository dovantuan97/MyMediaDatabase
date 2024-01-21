package com.example.dmdb.my_entries;

import com.example.dmdb.enums.Status;
import com.example.dmdb.medias.Media;
import com.example.dmdb.users.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MyEntryService {

    private final MyEntryRepo repo;
    public List<Long> getMyEntriesId(User user) {
        return repo.findAllByUserId(user.getId()).stream()
                .map(e -> e.getMedia().getId())
                .toList();

    }

    public void addToList(User user, Media media, Status status) {
        MyEntry entry = new MyEntry(user, media, status);
        repo.save(entry);
    }
}
