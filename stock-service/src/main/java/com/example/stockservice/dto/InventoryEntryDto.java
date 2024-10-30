package com.example.stockservice.dto;

import com.example.stockservice.models.InventoryEntry;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class InventoryEntryDto {
    private long id;
    private String article_id;
    private int quantity;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


    public InventoryEntry toEntity() {
        InventoryEntry inventoryEntry = new InventoryEntry();
        inventoryEntry.setId(id);
        inventoryEntry.setArticleId(article_id);
        inventoryEntry.setQuantity(quantity);
        inventoryEntry.setCreatedAt(createdAt);
        inventoryEntry.setUpdatedAt(updatedAt);
        return inventoryEntry;
    }

    @Override
    public String toString(){
        return "InventoryEntryDto{" +
                "id=" + id +
                ", article_id='" + article_id + '\'' +
                ", quantity=" + quantity +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}