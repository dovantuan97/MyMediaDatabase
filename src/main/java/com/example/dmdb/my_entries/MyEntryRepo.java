package com.example.dmdb.my_entries;

import com.example.dmdb.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyEntryRepo extends JpaRepository<MyEntry, Long> {
    List<MyEntry> findAllByUserId(Long id);

    List<MyEntry> findAllByUserIdAndStatus(Long UserId, Status status);
}
