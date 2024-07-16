package com.sadikov.telegramBot.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table()
public class Payment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private LocalDateTime paymentDate;
    @Column
    private int countHookah = 0;
    @Column
    private int money = 0;
    @Column
    private boolean isPay = false;

}
