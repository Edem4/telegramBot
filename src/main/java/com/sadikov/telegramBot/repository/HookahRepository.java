package com.sadikov.telegramBot.repository;

import com.sadikov.telegramBot.model.Hookah;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HookahRepository extends JpaRepository<Hookah, Long> {
}
