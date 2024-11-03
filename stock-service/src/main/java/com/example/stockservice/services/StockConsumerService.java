package com.example.stockservice.services;

import org.example.StockArticle;
import org.example.StockEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class StockConsumerService {

    private final InventoryEntryService inventoryEntryService;

    @Autowired
    public StockConsumerService(InventoryEntryService inventoryEntryService) {
        this.inventoryEntryService = inventoryEntryService;
    }

    @KafkaListener(topics = "stock-topic", groupId = "stock-group")
        public void consume(StockEvent stockEvent) {

            // Access the payload
            Map<String, Object> payload = stockEvent.getPayload();
            List<StockArticle> commande = (List<StockArticle>) payload.get("commande");
            if (commande != null) {
                for (StockArticle stockArticle : commande) {
                    inventoryEntryService.decreaseStock(stockArticle.getArticleId(), stockArticle.getQuantity());
                }
            }

        }
}
