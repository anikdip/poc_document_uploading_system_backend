package com.example.poc.controller;

import com.example.poc.model.DrivingLicense;
import com.example.poc.repository.DrivingLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/person")
public class DrivingLicenseController {
    @Autowired
    DrivingLicenseRepository drivingLicenseRepository;

    @PostMapping("/drivingLicense")
    @Transactional
    public DrivingLicense createDrivingLicense(@Valid @RequestBody DrivingLicense drivingLicense) {
        drivingLicenseRepository.deleteByPersonId(drivingLicense.getPerson_id());
        return drivingLicenseRepository.save(drivingLicense);
    }
}
