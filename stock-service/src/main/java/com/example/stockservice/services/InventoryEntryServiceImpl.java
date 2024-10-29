package com.example.stockservice.services;

import com.example.stockservice.dto.InventoryEntryDto;
import com.example.stockservice.models.InventoryEntry;
import com.example.stockservice.repositories.InventoryEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryEntryServiceImpl implements InventoryEntryService {

    @Autowired
    private InventoryEntryRepository inventoryEntryRepsitory;

    @Override
    public InventoryEntry createEntry(String article_id, int quantity) {
        System.out.println("Creating entry---");
        InventoryEntry inventoryEntry = new InventoryEntry(article_id,quantity);
        return inventoryEntryRepsitory.saveAndFlush(inventoryEntry);
    }

    @Override
    public List<InventoryEntryDto> getAllEntrys() {
        List<InventoryEntry> data = inventoryEntryRepsitory.findAll();
        // tout convertir en dto
        return data.stream().map(InventoryEntry::toDto).toList();
    }

    @Override
    public InventoryEntryDto getEntryById(Long id) {
        return inventoryEntryRepsitory.findById(id).map(InventoryEntry::toDto).orElse(null);
    }

    @Override
    public InventoryEntryDto updateEntry(String article_id, int quantity) {
        InventoryEntry inventoryEntry = inventoryEntryRepsitory.findByArticleId(article_id).orElse(null);
        if(inventoryEntry != null){
            // update in the db
            inventoryEntryRepsitory.updateQuantityById(inventoryEntry.getId(), inventoryEntry.getQuantity() + quantity);
        }
        return null;
    }

    @Override
    public void deleteEntry(int id) {    }

    @Override
    public InventoryEntryDto getEntryByArticleId(String articleId){
        return inventoryEntryRepsitory.findByArticleId(articleId).map(InventoryEntry::toDto).orElse(null);
    }
}
