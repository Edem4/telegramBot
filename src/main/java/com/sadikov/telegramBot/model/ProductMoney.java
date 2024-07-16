package com.sadikov.telegramBot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table()
public class ProductMoney {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private int moneyProduct;

    public ProductMoney() {
        this.moneyProduct = 0;
    }
}
