package com.example.stockservice.models;

import com.example.stockservice.dto.InventoryEntryDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name="stock")
public class InventoryEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "article_id", nullable = false)
    private String articleId;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;



    // Automatically set timestamps before persistence
    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }

    public InventoryEntry(String article_id, int quantity) {
        this.articleId = article_id;
        this.quantity = quantity;
    }

    public InventoryEntryDto toDto() {
        InventoryEntryDto inventoryEntryDto = new InventoryEntryDto();
        inventoryEntryDto.setId(id);
        inventoryEntryDto.setArticle_id(articleId);
        inventoryEntryDto.setQuantity(quantity);
        inventoryEntryDto.setCreatedAt(createdAt);
        inventoryEntryDto.setUpdatedAt(updatedAt);
        return inventoryEntryDto;
    }
}
