package com.example.poc.repository;

import com.example.poc.model.DocumentTypeFields;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DocumentTypeFieldsRepository extends JpaRepository<DocumentTypeFields, Long> {

    @Modifying
    @Query("delete from DocumentTypeFields d where d.document_type_id=:document_type_id")
    void deleteByDocumentTypeId(@Param("document_type_id") long document_type_id);

    @Query("select d from DocumentTypeFields d where d.document_type_id=:document_type_id")
    List<DocumentTypeFields> getDocumentTypeFieldsByDocumentType(@Param("document_type_id") long document_type_id);
}
