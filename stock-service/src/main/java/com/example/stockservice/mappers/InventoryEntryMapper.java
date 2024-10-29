package com.example.stockservice.mappers;

import com.example.stockservice.dto.InventoryEntryDto;
import com.example.stockservice.models.InventoryEntry;

public class InventoryEntryMapper {

    public static InventoryEntry toDto(InventoryEntry stock) {
        return new InventoryEntry(
                stock.getId(),
                stock.getArticleId(),
                stock.getQuantity(),
                stock.getCreatedAt(),
                stock.getUpdatedAt()
        );
    }

    public static InventoryEntry toEntity(InventoryEntryDto inventoryEntryDto) {
        InventoryEntry stock = new InventoryEntry();
        stock.setId(inventoryEntryDto.getId());
        stock.setArticleId(inventoryEntryDto.getArticle_id());
        stock.setQuantity(inventoryEntryDto.getQuantity());
        stock.setCreatedAt(inventoryEntryDto.getCreatedAt());
        stock.setUpdatedAt(inventoryEntryDto.getUpdatedAt());
        return stock;
    }
}
