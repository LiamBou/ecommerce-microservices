package com.example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StockEvent {
    private final EventType eventType = EventType.STOCK_UPDATED;
    private String timestamp;
    private Map<String, Object> payload;

    public StockEvent(List<StockArticle> commande) {
        timestamp = String.valueOf(System.currentTimeMillis());
        this.payload = new HashMap<>();
        payload.put("commande", commande);
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public Map<String, Object> getPayload() {
        return payload;
    }
}
