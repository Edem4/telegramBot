package com.sadikov.telegramBot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table()
public class Hookah {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private int count;
    @Column
    private LocalDateTime date;

    @Column
    private int amountOfMoney;

    public Hookah() {
        this.date = LocalDateTime.now();
    }
}
