package com.example.poc.repository;

import com.example.poc.model.DrivingLicense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivingLicenseRepository extends JpaRepository<DrivingLicense, Long> {

    @Modifying
    @Query("delete from DrivingLicense dl where dl.person_id=:parent_id")
    void deleteByPersonId(@Param("parent_id") long parent_id);

    @Query("select d from DrivingLicense d where d.person_id=:person_id")
    DrivingLicense getDrivingLicenseByPerson(@Param("person_id") long person_id);
}
