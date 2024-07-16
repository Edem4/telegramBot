package com.sadikov.telegramBot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table()
public class RestaurantMoney {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private LocalDateTime dateGive;
    @Column
    private int moneyBoss;

    @Column
    private boolean isGive = false;

//    @Override
//    public String toString() {
//        return "Дата: " + dateGive +
//                ", Сумма: " + moneyBoss;
//    }

    public RestaurantMoney() {
        this.moneyBoss = 0;
    }
}
