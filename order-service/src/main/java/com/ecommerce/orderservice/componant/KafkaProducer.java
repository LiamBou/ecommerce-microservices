package com.ecommerce.orderservice.componant;

import com.ecommerce.orderservice.model.OrderItem;
import com.example.StockArticle;
import com.example.StockEvent;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Component
public class KafkaProducer {
    private final KafkaTemplate<String, StockEvent> kafkaTemplate;
    private final String TOPIC_NAME = "stock-topic";

    public KafkaProducer(KafkaTemplate<String, StockEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendStockChanges(List<OrderItem> items) {
        List<StockArticle> stockArticles = new ArrayList<>();
        for (OrderItem item : items) {
            stockArticles.add(new StockArticle(item.getProductId(), item.getQuantity()));
        }
        StockEvent stockEvent = new StockEvent(stockArticles);
        kafkaTemplate.send(TOPIC_NAME, stockEvent);
        System.out.println("Stock changes sent to Kafka topic" + stockEvent.toString());
    }
}
