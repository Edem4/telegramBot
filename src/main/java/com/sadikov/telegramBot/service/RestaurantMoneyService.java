package com.sadikov.telegramBot.service;

import com.sadikov.telegramBot.model.RestaurantMoney;
import com.sadikov.telegramBot.repository.RestaurantMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class RestaurantMoneyService {
    @Autowired
    private RestaurantMoneyRepository restaurantMoneyRepository;

    @Transactional()
    public void updateRecord(int countHookah) {
        Optional<RestaurantMoney> lastRecord = restaurantMoneyRepository.findLatest();
        if (!lastRecord.get().isGive()) {
            RestaurantMoney restaurantMoney = lastRecord.get();
            restaurantMoney.setMoneyBoss(restaurantMoney.getMoneyBoss() + (countHookah * 400));
        } else {
            restaurantMoneyRepository.save(new RestaurantMoney());
            updateRecord(countHookah);
        }
    }

    @Transactional(readOnly = true)
    public String getBossMoney(){
        String result;
        Optional<RestaurantMoney> lastRecord = restaurantMoneyRepository.findLatest();
        if (lastRecord.get().isGive()) {
            RestaurantMoney restaurantMoney = lastRecord.get();
            result = " " + restaurantMoney.getMoneyBoss();
        } else {
            result = "";
        }
        return result;
    }

    public String getAllBossMoney(){
        StringBuilder sb = new StringBuilder();
        List<RestaurantMoney> allRecord = restaurantMoneyRepository.findAll();

        if (!allRecord.isEmpty()) {
            for (RestaurantMoney money : allRecord) {
                sb.append(money.toString()).append("\n");
            }
        } else {
            sb = new StringBuilder("Отсутствуют записи!");
        }
        return sb.toString();
    }

}
