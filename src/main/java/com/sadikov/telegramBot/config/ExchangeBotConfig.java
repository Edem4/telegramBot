package com.sadikov.telegramBot.config;

import com.sadikov.telegramBot.bot.ExchangeRatesBot;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

@Configuration
public class ExchangeBotConfig {

    @Bean
    public TelegramBotsApi telegramBotsApi(ExchangeRatesBot exchangeRatesBot) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(exchangeRatesBot);
        return  telegramBotsApi;
    }
}
