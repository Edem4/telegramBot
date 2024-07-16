package com.sadikov.telegramBot.service;

import com.sadikov.telegramBot.exception.EmberNotFoundException;
import com.sadikov.telegramBot.model.Ember;
import com.sadikov.telegramBot.repository.EmberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmberService {
    @Autowired
    private EmberRepository emberRepository;

    @Transactional()
    public void updateRecord(int countHookah) {
        Optional<Ember> lastRecord = emberRepository.findLatest();
        if (lastRecord.isPresent()) {
            Ember ember = lastRecord.get();
            ember.setCount(ember.getCount() - (countHookah * 3));
        } else {
            emberRepository.save(new Ember());
            updateRecord(countHookah);
        }
    }
    @Transactional()
    public void addEmbers(int count){
        Optional<Ember> lastRecord = emberRepository.findLatest();
        if (lastRecord.isPresent()) {
            Ember ember = lastRecord.get();
            ember.setCount(ember.getCount() + (count * 72));
        } else {
            emberRepository.save(new Ember());
            addEmbers(count);
        }
    }

    @Transactional(readOnly = true)
    public String getEmber() throws EmberNotFoundException {
        Optional<Ember> lastRecord = emberRepository.findLatest();
        String embers = null;
        if (lastRecord.isPresent()) {
            Ember ember = lastRecord.get();
            embers = "" + ember.getCount() + "";
        }else {
            throw new EmberNotFoundException("");
        }
        return embers;
    }

}
