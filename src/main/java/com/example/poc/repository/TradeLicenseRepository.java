package com.example.poc.repository;

import com.example.poc.model.TradeLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeLicenseRepository extends JpaRepository<TradeLicense, Long> {

    @Modifying
    @Query("delete from TradeLicense tl where tl.person_id=:parent_id")
    void deleteByPersonId(@Param("parent_id") long parent_id);

    @Query("select t from TradeLicense t where t.person_id=:person_id")
    TradeLicense getTradeLicenseByPerson(@Param("person_id") long person_id);
}
