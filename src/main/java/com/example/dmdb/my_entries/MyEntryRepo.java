package com.example.dmdb.my_entries;

import com.example.dmdb.enums.Status;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface MyEntryRepo extends ListCrudRepository<MyEntry, Long> {
    List<MyEntry> findAllByUserId(Long id);

    List<MyEntry> findAllByUserIdAndStatus(Long UserId, Status status);
}
