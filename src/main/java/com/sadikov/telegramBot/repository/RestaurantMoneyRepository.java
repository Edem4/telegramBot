package com.sadikov.telegramBot.repository;

import com.sadikov.telegramBot.model.RestaurantMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RestaurantMoneyRepository extends JpaRepository<RestaurantMoney,Long> {
    Optional<RestaurantMoney> findById(Long id);

    @Query("SELECT e FROM boss_money e ORDER BY e.createdAt DESC LIMIT 1")
    Optional<RestaurantMoney> findLatest();
}
