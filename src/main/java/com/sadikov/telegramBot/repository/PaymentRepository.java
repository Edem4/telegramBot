package com.sadikov.telegramBot.repository;

import com.sadikov.telegramBot.model.Payment;
import com.sadikov.telegramBot.model.RestaurantMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
    @Query("SELECT e FROM payment e ORDER BY e.createdAt DESC LIMIT 1")
    Optional<Payment> findLatest();
}
