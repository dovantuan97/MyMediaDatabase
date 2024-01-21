package com.example.dmdb.my_entries;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface MyEntryRepo extends ListCrudRepository<MyEntry, Long> {
    List<MyEntry> findAllByUserId(Long id);
}
