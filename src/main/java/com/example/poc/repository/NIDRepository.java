package com.example.poc.repository;

import com.example.poc.model.NID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NIDRepository extends JpaRepository<NID, Long> {

    @Modifying
    @Query("delete from NID n where n.person_id=:person_id")
    void deleteByPersonId(@Param("person_id") long parent_id);

    @Query("select n from NID n where n.person_id=:person_id")
    NID getNIDByPerson(@Param("person_id") long person_id);

}
