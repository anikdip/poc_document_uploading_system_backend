package com.example.poc.controller;

import com.example.poc.exception.ResourceNotFoundException;
import com.example.poc.model.DocumentTypeFields;
import com.example.poc.repository.DocumentTypeFieldsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/person")
public class DocumentTypeFieldsController {
    @Autowired
    DocumentTypeFieldsRepository documentTypeFieldsRepository;

    @GetMapping("/documentTypeFields")
    public List<DocumentTypeFields> getAllDocumentType() {
        return documentTypeFieldsRepository.findAll();
    }

    @PostMapping("/documentTypeFields")
    public DocumentTypeFields createDocumentTypeFields(@Valid @RequestBody DocumentTypeFields documentTypeFields){
        return documentTypeFieldsRepository.save(documentTypeFields);
    }

    @DeleteMapping("/deleteDocumentTypeFields/{id}")
    public Map<String, Boolean> deleteDocumentTypeFields(@PathVariable(value = "id") Long documentTypeFieldsId)
            throws ResourceNotFoundException {
        DocumentTypeFields documentTypeFields = documentTypeFieldsRepository.findById(documentTypeFieldsId)
                .orElseThrow(() -> new ResourceNotFoundException("Document type field not found for this id :: " + documentTypeFieldsId));

        documentTypeFieldsRepository.delete(documentTypeFields);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @GetMapping("/documentTypeFieldsByDocumentType/{id}")
    public List<DocumentTypeFields> documentTypeFieldsByDocumentType(@PathVariable(value = "id") Long documentTypeFieldsId) {
        return documentTypeFieldsRepository.getDocumentTypeFieldsByDocumentType(documentTypeFieldsId);
    }
}
