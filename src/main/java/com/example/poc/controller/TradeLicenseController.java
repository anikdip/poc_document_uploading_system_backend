package com.example.poc.controller;

import com.example.poc.exception.ResourceNotFoundException;
import com.example.poc.model.TradeLicense;
import com.example.poc.repository.TradeLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/person")
public class TradeLicenseController {
    @Autowired
    TradeLicenseRepository tradeLicenseRepository;

    @PostMapping("/tradeLicense")
    @Transactional
    public TradeLicense createTradeLicense(@Valid @RequestBody TradeLicense tradeLicense) {
        tradeLicenseRepository.deleteByPersonId(tradeLicense.getPerson_id());
        return tradeLicenseRepository.save(tradeLicense);
    }
}
