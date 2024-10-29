package com.example.stockservice.repositories;

import com.example.stockservice.models.InventoryEntry;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface InventoryEntryRepository extends JpaRepository<InventoryEntry, Long> {
    Optional<InventoryEntry> findByArticleId(String articleId);

    @Modifying
    @Transactional
    @Query("UPDATE InventoryEntry e SET e.quantity = :quantity WHERE e.id = :id")
    int updateQuantityById(@Param("id") Long id, @Param("quantity") int quantity);
}
