package com.example.poc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "person")
public class Person implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private String firstName;
    private String lastName;
    private String emailId;
    private String birthdate;
    private String fathername;
    private String mothername;
    private long mobileno;

    @OneToMany(mappedBy="person", cascade = CascadeType.ALL)
    List<PersonDocumentInfo> personDocumentInfos;

    public Person(){

    }

    public Person(String firstName, String lastName, String emailId, String birthdate, String fathername, String mothername, long mobileno){
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.birthdate = birthdate;
        this.fathername = fathername;
        this.mothername = mothername;
        this.mobileno = mobileno;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    @Column(name = "person_id", nullable = false)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "first_name", nullable = false)
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", nullable = false)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "email")
    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Column(name = "dob", nullable = false)
    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    @Column(name = "father_name", nullable = false)
    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    @Column(name = "mother_name", nullable = false)
    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    @Column(name = "mobile_no", nullable = false)
    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

//    public List<PersonDocumentInfo> getPersonDocumentInfos() {
//        return personDocumentInfos;
//    }
//
//    public void setPersonDocumentInfos(List<PersonDocumentInfo> personDocumentInfos) {
//        this.personDocumentInfos = personDocumentInfos;
//    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", fathername='" + fathername + '\'' +
                ", mothername='" + mothername + '\'' +
                ", mobileno=" + mobileno +
                '}';
    }
}
