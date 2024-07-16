package com.sadikov.telegramBot.service;

import com.sadikov.telegramBot.model.Hookah;
import com.sadikov.telegramBot.repository.HookahRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class HookahService {

    @Autowired
    private HookahRepository hookahRepository;
    @Autowired
    private RestaurantMoneyService restaurantMoneyService;
    @Autowired
    private ProductMoneyService productMoneyService;
    @Autowired
    private PaymentService paymentService;
    @Autowired
    private EmberService emberService;


    @Transactional()
    public void crateRecordHookah(int quantity){
        Hookah hookah = new Hookah();
        hookah.setCount(quantity);
        hookah.setAmountOfMoney(quantity * 800);

//        restaurantMoneyService.updateRecord(quantity);
//        emberService.updateRecord(quantity);
//        productMoneyService.updateRecord(quantity);
//        paymentService.updateRecord(quantity,hookah.getAmountOfMoney());

        hookahRepository.save(hookah);
    }

}
