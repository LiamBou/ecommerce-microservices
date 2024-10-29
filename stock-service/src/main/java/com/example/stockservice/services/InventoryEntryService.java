package com.example.stockservice.services;

import com.example.stockservice.dto.InventoryEntryDto;
import com.example.stockservice.models.InventoryEntry;
import org.springframework.stereotype.Service;

import java.util.List;


public interface InventoryEntryService {
    InventoryEntry createEntry(String article_id, int quantity);
    List<InventoryEntryDto> getAllEntrys();
    InventoryEntryDto getEntryById(Long id);
    InventoryEntryDto updateEntry(String article_id, int quantity);
    void deleteEntry(int id);
    InventoryEntryDto getEntryByArticleId(String articleId);

}
