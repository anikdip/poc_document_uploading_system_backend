package com.example.poc.controller;

import com.example.poc.model.PersonDocumentInfo;
import com.example.poc.repository.PersonDocumentInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
public class PersonDocumentInfoController {
    @Autowired
    PersonDocumentInfoRepository personDocumentInfoRepository;

    @PostMapping("/personDocumentInfo")
    public PersonDocumentInfo createPersonDocumentInfo(@Valid @RequestBody PersonDocumentInfo personDocumentInfo){
        return personDocumentInfoRepository.save(personDocumentInfo);
    }

    @GetMapping("/personDocumentInfo/{id}")
    public List<PersonDocumentInfo> getPersonDocumentInfoByPersonId(@PathVariable(value = "id") Long personId) {
        return personDocumentInfoRepository.getPersonDocumentInfoByPersonId(personId);
    }
}
