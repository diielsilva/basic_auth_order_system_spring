package com.olix.stock_system.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.olix.stock_system.api.representation.input.SaveEntry;
import com.olix.stock_system.api.representation.output.ShowEntry;
import com.olix.stock_system.common.mapper.ModelMapper;
import com.olix.stock_system.domain.model.Entry;
import com.olix.stock_system.domain.service.EntryService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/entries")
public class EntryController {
    private EntryService entryService;
    private ModelMapper modelMapper;

    public EntryController(EntryService entryService, ModelMapper modelMapper) {
        this.entryService = entryService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid SaveEntry saveEntry) {
        Entry entry = this.modelMapper.getEntryMapper().fromSaveEntryToEntry(saveEntry);
        this.entryService.save(entry);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ShowEntry>> findAll() {
        List<Entry> entries = this.entryService.findAll();
        List<ShowEntry> showEntries = this.modelMapper.getEntryMapper().fromEntryListToShowEntryList(entries, this.modelMapper.getProductMapper());
        return new ResponseEntity<List<ShowEntry>>(showEntries, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowEntry> findById(@PathVariable Long id) {
        Entry entry = this.entryService.findById(id);
        ShowEntry showEntry = this.modelMapper.getEntryMapper().fromEntryToShowEntry(entry,
                this.modelMapper.getProductMapper());
        return new ResponseEntity<ShowEntry>(showEntry, HttpStatus.OK);
    }
}
