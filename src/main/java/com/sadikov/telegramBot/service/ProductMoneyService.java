package com.sadikov.telegramBot.service;

import com.sadikov.telegramBot.model.ProductMoney;
import com.sadikov.telegramBot.repository.ProductMoneyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class ProductMoneyService {

    @Autowired
    private ProductMoneyRepository productMoneyRepository;

    @Transactional
    public void updateRecord(int countHookah) {
        Optional<ProductMoney> lastRecord = productMoneyRepository.findLatest();

        if (lastRecord.isPresent()) {
            ProductMoney productMoney = lastRecord.get();
            productMoney.setMoneyProduct(productMoney.getMoneyProduct() + (countHookah * 250));
        } else {
            productMoneyRepository.save(new ProductMoney());
            updateRecord(countHookah);
        }
    }

    @Transactional(readOnly = true)
    public String getProductMoney(){
        String result;
        Optional<ProductMoney> lastRecord = productMoneyRepository.findLatest();
        if (lastRecord.isPresent()) {
            ProductMoney productMoney = lastRecord.get();
            result = ""+ productMoney.getMoneyProduct();
        } else {
            result = "";
        }
        return result;
    }
}
