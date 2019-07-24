package com.example.poc.repository;

import com.example.poc.model.PersonDocumentInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PersonDocumentInfoRepository extends JpaRepository<PersonDocumentInfo, Long> {

    @Modifying
    @Query("delete from PersonDocumentInfo pdi where pdi.person_id=:person_id")
    void deleteByPersonId(@Param("person_id") long person_id);

    @Query("select pdi from PersonDocumentInfo pdi where pdi.person_id=:person_id")
    List<PersonDocumentInfo> getPersonDocumentInfoByPersonId(@Param("person_id") long person_id);
}
