package com.sadikov.telegramBot.repository;

import com.sadikov.telegramBot.model.Ember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmberRepository extends JpaRepository<Ember,Long> {
    @Query("SELECT e FROM ember e ORDER BY e.createdAt DESC LIMIT 1")
    Optional<Ember> findLatest();
}
