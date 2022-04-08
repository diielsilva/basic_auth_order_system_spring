package com.olix.stock_system.api.controller;

import java.util.List;

import javax.validation.Valid;

import com.olix.stock_system.api.representation.input.SaveExit;
import com.olix.stock_system.api.representation.output.ShowExit;
import com.olix.stock_system.common.mapper.ModelMapper;
import com.olix.stock_system.domain.model.CustomExit;
import com.olix.stock_system.domain.service.CustomExitService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/exits")
public class CustomExitController {
    private CustomExitService customExitService;
    private ModelMapper modelMapper;

    public CustomExitController(CustomExitService customExitService, ModelMapper modelMapper) {
        this.customExitService = customExitService;
        this.modelMapper = modelMapper;
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody @Valid SaveExit saveExit) {
        CustomExit customExit = this.modelMapper.getCustomExitMapper().fromSaveExitToCustomExit(saveExit);
        this.customExitService.save(customExit);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ShowExit>> findAll() {
        List<CustomExit> customExits = this.customExitService.findAll();
        List<ShowExit> showExits = this.modelMapper.getCustomExitMapper().fromCustomExitListToShowExitList(customExits,
                this.modelMapper.getProductMapper());
        return new ResponseEntity<List<ShowExit>>(showExits, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ShowExit> findById(@PathVariable Long id) {
        CustomExit customExit = this.customExitService.findById(id);
        ShowExit showExit = this.modelMapper.getCustomExitMapper().fromCustomExitToShowExit(customExit,
                this.modelMapper.getProductMapper());
        return new ResponseEntity<ShowExit>(showExit, HttpStatus.OK);
    }
}
