package com.olix.stock_system.domain.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import com.olix.stock_system.domain.exception.ModelNotFoundException;
import com.olix.stock_system.domain.model.Entry;
import com.olix.stock_system.domain.model.EntryItem;
import com.olix.stock_system.domain.repository.EntryItemRepository;
import com.olix.stock_system.domain.repository.EntryRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EntryService {
    private EntryRepository entryRepository;
    private EntryItemRepository entryItemRepository;
    private ProductService productService;

    public EntryService(EntryRepository entryRepository, EntryItemRepository entryItemRepository,
            ProductService productService) {
        this.entryRepository = entryRepository;
        this.entryItemRepository = entryItemRepository;
        this.productService = productService;
    }

    @Transactional
    public void save(Entry entry) {
        entry.setEntryDate(OffsetDateTime.now());
        this.entryRepository.save(entry);
        for (EntryItem entryItem : entry.getEntryItems()) {
            entryItem.setEntry(entry);
            this.productService.incrementAmount(entryItem.getProduct().getId(), entryItem.getAmount());
            this.entryItemRepository.save(entryItem);
        }
    }

    public List<Entry> findAll() {
        return this.entryRepository.findAll();
    }

    public Entry findById(Long id) {
        Optional<Entry> databaseEntry = this.entryRepository.findById(id);
        if (databaseEntry.isEmpty()) {
            throw new ModelNotFoundException("Entry");
        }
        return databaseEntry.get();
    }

}
