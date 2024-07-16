package com.sadikov.telegramBot.repository;

import com.sadikov.telegramBot.model.ProductMoney;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ProductMoneyRepository extends JpaRepository<ProductMoney,Long> {
    @Query("SELECT e FROM product_money e ORDER BY e.createdAt DESC LIMIT 1")
    Optional<ProductMoney> findLatest();
}
