package com.example.stockservice.deserializer;

import com.example.StockEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import java.util.Map;

public class StockEventDeserializer implements Deserializer<StockEvent> {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        // No configuration needed
    }

    @Override
    public StockEvent deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, StockEvent.class);
        } catch (Exception e) {
            throw new SerializationException("Error deserializing StockEvent", e);
        }
    }

    @Override
    public void close() {
        // No resources to close
    }
}