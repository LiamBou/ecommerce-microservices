package com.example.stockservice.configuration;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaTopicConfig {

    /**
     * Cree automatiquement un topic Kafka avec le nom "stock-topic" et une partition
     * si celui n'existe pas au lancement de l'application
     * @return le topic cree
     */
    @Bean
    public NewTopic stockTopic() {
        return new NewTopic("stock-topic", 1, (short) 1);
    }
}
