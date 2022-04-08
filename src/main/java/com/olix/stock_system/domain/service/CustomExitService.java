package com.olix.stock_system.domain.service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;

import com.olix.stock_system.domain.exception.ModelNotFoundException;
import com.olix.stock_system.domain.model.CustomExit;
import com.olix.stock_system.domain.model.ExitItem;
import com.olix.stock_system.domain.repository.CustomExitRepository;
import com.olix.stock_system.domain.repository.ExitItemRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomExitService {
    private CustomExitRepository customExitRepository;
    private ExitItemRepository exitItemRepository;
    private ProductService productService;

    public CustomExitService(CustomExitRepository customExitRepository, ExitItemRepository exitItemRepository,
            ProductService productService) {
        this.customExitRepository = customExitRepository;
        this.exitItemRepository = exitItemRepository;
        this.productService = productService;
    }

    @Transactional
    public void save(CustomExit customExit) {
        customExit.setExitDate(OffsetDateTime.now());
        this.customExitRepository.save(customExit);
        for (ExitItem exitItem : customExit.getExitItems()) {
            exitItem.setCustomExit(customExit);
            this.productService.decrementAmount(exitItem.getProduct().getId(), exitItem.getAmount());
            this.exitItemRepository.save(exitItem);
        }
    }

    public List<CustomExit> findAll() {
        return this.customExitRepository.findAll();
    }

    public CustomExit findById(Long id) {
        Optional<CustomExit> databaseCustomExit = this.customExitRepository.findById(id);
        if(databaseCustomExit.isEmpty()) {
            throw new ModelNotFoundException("CustomExit");
        }
        return databaseCustomExit.get();
    }
}
