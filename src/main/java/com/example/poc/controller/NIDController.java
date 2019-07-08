package com.example.poc.controller;

import com.example.poc.model.NID;
import com.example.poc.repository.NIDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/person")
public class NIDController {
    @Autowired
    NIDRepository nidRepository;

    @PostMapping("/nid")
    @Transactional
    public NID createNID(@Valid @RequestBody NID nid) {
        nidRepository.deleteByPersonId(nid.getPerson_id());
        return nidRepository.save(nid);
    }
}
