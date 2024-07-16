package com.sadikov.telegramBot.service;

import com.sadikov.telegramBot.model.Payment;
import com.sadikov.telegramBot.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Transactional()
    public void updateRecord(int countHookah, int sumMoney) {
        Optional<Payment> lastRecord = paymentRepository.findLatest();
        if (!(lastRecord.isEmpty() || lastRecord.get().isPay())) {
            Payment p = lastRecord.get();
            p.setMoney(p.getMoney() + sumMoney);
            p.setCountHookah(p.getCountHookah() + countHookah);
        } else {
            paymentRepository.save(new Payment());
            updateRecord(countHookah, sumMoney);
        }
    }


    @Transactional(readOnly = true)
    public String getPayment() {
        String result;

        Optional<Payment> lastRecord = paymentRepository.findLatest();
        if (!(lastRecord.isEmpty() || lastRecord.get().isPay())) {
            Payment p = lastRecord.get();
            result = " " + p.getMoney() +
                    "" + p.getCountHookah() + "";
        } else {
            result = "";
        }
        return result;
    }
}
