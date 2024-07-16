package com.sadikov.telegramBot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ember")
public class Ember {
    @Id
    @Column()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private  int count = 0 ;
}
