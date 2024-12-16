package com.dmitryprod.producer;

import com.dmitryprod.producer.bot.config.TelegramBotProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(TelegramBotProperties.class)
public class BotMessageProducerApplication {

    public static void main(String[] args) {
        SpringApplication.run(BotMessageProducerApplication.class, args);
    }
}
