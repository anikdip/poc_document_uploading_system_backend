package com.example.poc.controller;

import com.example.poc.exception.ResourceNotFoundException;
import com.example.poc.model.DocumentType;
import com.example.poc.repository.DocumentTypeFieldsRepository;
import com.example.poc.repository.DocumentTypeRepository;
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
public class DocumentTypeController {
    @Autowired
    DocumentTypeRepository documentTypeRepository;
    @Autowired
    DocumentTypeFieldsRepository documentTypeFieldsRepository;

    @GetMapping("/documentType")
    public List<DocumentType> getAllDocumentType() {
        return documentTypeRepository.findAll();
    }

    @GetMapping("/documentType/{id}")
    public ResponseEntity<DocumentType> getPersonIdById(@PathVariable(value = "id") Long documentTypeId)
            throws ResourceNotFoundException {
        DocumentType documentType = documentTypeRepository.findById(documentTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Document type not found for this id :: " + documentTypeId));

        return ResponseEntity.ok().body(documentType);
    }

    @PostMapping("/documentType")
    public DocumentType createDocumentType(@Valid @RequestBody DocumentType documentType){
        return documentTypeRepository.save(documentType);
    }

    @Transactional
    @DeleteMapping("/documentType/{id}")
    public Map<String, Boolean> deleteDocumentType(@PathVariable(value = "id") Long documentTypeId)
            throws ResourceNotFoundException {
        DocumentType documentType = documentTypeRepository.findById(documentTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Document type not found for this id :: " + documentTypeId));

        documentTypeRepository.delete(documentType);
        documentTypeFieldsRepository.deleteByDocumentTypeId(documentTypeId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @PutMapping("/documentType/{id}")
    public ResponseEntity<DocumentType> updatePerson(@PathVariable(value = "id") Long documentTypeId,
                                               @Valid @RequestBody DocumentType documentTypeDetails) throws ResourceNotFoundException {
        DocumentType documentType = documentTypeRepository.findById(documentTypeId)
                .orElseThrow(() -> new ResourceNotFoundException("Document Type not found for this id :: " + documentTypeId));

        documentType.setType(documentTypeDetails.getType());
        final DocumentType updatedDocumentType = documentTypeRepository.save(documentType);
        return ResponseEntity.ok(updatedDocumentType);
    }
}
