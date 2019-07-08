package com.example.poc.controller;

import com.example.poc.exception.ResourceNotFoundException;
import com.example.poc.model.*;
import com.example.poc.repository.DrivingLicenseRepository;
import com.example.poc.repository.NIDRepository;
import com.example.poc.repository.PersonRepository;
import com.example.poc.repository.TradeLicenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

@RestController
@RequestMapping("/api/v1")
public class PersonController {
    @Autowired
    PersonRepository personRepository;
    @Autowired
    NIDRepository nidRepository;
    @Autowired
    TradeLicenseRepository tradeLicenseRepository;
    @Autowired
    DrivingLicenseRepository drivingLicenseRepository;

    @GetMapping("/person")
    public List<Person> getAllPerson() {
        return personRepository.findAll();
    }

    @GetMapping("/person/{id}")
    public ResponseEntity<Person> getPersonIdById(@PathVariable(value = "id") Long personId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

        return ResponseEntity.ok().body(person);
    }

    @GetMapping("/person/personDetails/{id}")
    public ResponseEntity<PersonInfo> getPersonDetails(HttpServletRequest request, @PathVariable(value = "id") Long personId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

        NID nid = nidRepository.getNIDByPerson(personId);
        DrivingLicense drivingLicense = drivingLicenseRepository.getDrivingLicenseByPerson(personId);
        TradeLicense tradeLicense = tradeLicenseRepository.getTradeLicenseByPerson(personId);

        PersonInfo personInfo = new PersonInfo();
        personInfo.setFirstName(person.getFirstName());
        personInfo.setLastName(person.getLastName());
        personInfo.setFathername(person.getFathername());
        personInfo.setMothername(person.getMothername());
        personInfo.setEmailId(person.getEmailId());
        personInfo.setBirthdate(person.getBirthdate());
        personInfo.setMobileno(person.getMobileno());
        if(nid!=null) {
            personInfo.setNid_number(nid.getNid_number());
            personInfo.setNid_document_img("http://"+request.getLocalName()+":"+request.getLocalPort()+"/images/uploaded_file/"+nid.getNid_document_img()+".jpg");
        }
        if(drivingLicense!=null) {
            personInfo.setDriving_license_number(drivingLicense.getDriving_license_number());
            personInfo.setDriving_license_issue_place(drivingLicense.getDriving_license_issue_place());
            personInfo.setDriving_license_expire_date(drivingLicense.getDriving_license_expire_date());
            personInfo.setDriving_license_document_img("http://"+request.getLocalName()+":"+request.getLocalPort()+"/images/uploaded_file/"+drivingLicense.getDriving_license_document_img()+".jpg");
        }
        if(tradeLicense!=null) {
            personInfo.setTrade_license_number(tradeLicense.getTrade_license_number());
            personInfo.setTrade_license_issue_place(tradeLicense.getTrade_license_issue_place());
            personInfo.setTrade_license_expire_date(tradeLicense.getTrade_license_expire_date());
            personInfo.setTrade_license_document_img("http://"+request.getLocalName()+":"+request.getLocalPort()+"/images/uploaded_file/"+tradeLicense.getTrade_license_document_img()+".jpg");
        }

        return ResponseEntity.ok().body(personInfo);
    }

    @PostMapping("/person")
    public Person createPerson(@Valid @RequestBody Person person) {
        return personRepository.save(person);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId,
                                                   @Valid @RequestBody Person personDetails) throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

        person.setEmailId(personDetails.getEmailId());
        person.setLastName(personDetails.getLastName());
        person.setFirstName(personDetails.getFirstName());
        person.setFathername(personDetails.getFathername());
        person.setMothername(personDetails.getMothername());
        person.setBirthdate(person.getBirthdate());
        person.setMobileno(person.getMobileno());
        final Person updatedPerson = personRepository.save(person);
        return ResponseEntity.ok(updatedPerson);
    }

    @Transactional
    @DeleteMapping("/person/{id}")
    public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId)
            throws ResourceNotFoundException {
        Person person = personRepository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));

        personRepository.delete(person);
        nidRepository.deleteByPersonId(personId);
        drivingLicenseRepository.deleteByPersonId(personId);
        tradeLicenseRepository.deleteByPersonId(personId);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }

    @RequestMapping(value="/person/upload", method=RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> uploadFile(@RequestParam("fileinfo") MultipartFile file, @RequestParam("person_id") String person_id, @RequestParam("type") String type) throws IOException {
        String extension = "";

        System.out.println("Inside Upload file method");

        String file_path = System.getProperty("user.dir")+"\\src\\main\\resources\\static\\images\\uploaded_file\\";

        int i = file.getOriginalFilename().lastIndexOf('.');
        if (i > 0) {
            extension = file.getOriginalFilename().substring(i+1);
        }
        File convertFile = new File(file_path+type+"_"+person_id+"."+extension);
        convertFile.createNewFile();
        FileOutputStream fout = new FileOutputStream(convertFile);
        fout.write(file.getBytes());
        fout.close();
        System.out.println("File is uploaded successfully");
        return new ResponseEntity<>("File is uploaded successfully", HttpStatus.OK);
    }
}
