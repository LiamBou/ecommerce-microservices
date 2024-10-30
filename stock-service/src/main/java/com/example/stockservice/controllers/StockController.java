package com.example.stockservice.controllers;

import com.example.stockservice.dto.InventoryEntryDto;
import com.example.stockservice.models.InventoryEntry;
import com.example.stockservice.services.InventoryEntryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.kafka.core.KafkaTemplate;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@RestController("api/v1/stock/")
public class StockController {

  private final InventoryEntryService inventoryEntryService;

    @Autowired
    public StockController(KafkaTemplate<String, String> kafkaTemplate, InventoryEntryService inventoryEntryService) {
        this.inventoryEntryService = inventoryEntryService;
    }

    /**
     * Récupérer tous les articles de l'inventaire
     * @return la liste des articles avec leur quantité
     */
    @GetMapping("get/all")
    public List<InventoryEntryDto> getAllEntries() {
      var inventoryEntries = inventoryEntryService.getAllEntrys();
        for (InventoryEntryDto inventoryEntry : inventoryEntries) {
            System.out.println(inventoryEntry.toString());
        }
        return inventoryEntries;
  }

    /**
     * Récupérer la quantité d'un article de l'inventaire
     * @param articl_id l'id de l'article
     * @return la quantité de l'article
     */
    @GetMapping("get/{article_id}")
    public int getEntryById(@PathVariable("article_id") String articl_id) {
        var inventoryEntry = inventoryEntryService.getEntryByArticleId(articl_id);
        if (inventoryEntry == null) {
            return 0;
        }
        return inventoryEntry.getQuantity();
    }

    /**
     * Ajouter un article à l'inventaire
     * Si l'article existe déjà, on met à jour la quantité
     * @param article_id l'id de l'article
     * @param quantity la quantité à ajouter
     */
  @PostMapping("add/{article_id}/{quantity}")
  public void addArticle(@PathVariable("article_id") String article_id, @PathVariable("quantity") int quantity) {
      if(inventoryEntryService.getEntryByArticleId(article_id) != null) {
          // update le stock lié à l'item de l'inventaire
          inventoryEntryService.updateEntry(article_id, quantity);
    }
    else{
        inventoryEntryService.createEntry(article_id, quantity);
    }

  }


}
