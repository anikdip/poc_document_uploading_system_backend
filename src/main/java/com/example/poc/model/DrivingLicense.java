package com.example.poc.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "driving_license")
public class DrivingLicense implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private long person_id;
    private String driving_license_number;
    private String driving_license_expire_date;
    private String driving_license_issue_place;
    private String driving_license_document_img;

    public DrivingLicense(){

    }

    public DrivingLicense(long person_id, String driving_license_number, String driving_license_expire_date, String driving_license_issue_place) {
        this.person_id = person_id;
        this.driving_license_number = driving_license_number;
        this.driving_license_expire_date = driving_license_expire_date;
        this.driving_license_issue_place = driving_license_issue_place;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(long person_id) {
        this.person_id = person_id;
    }

    @Column(name = "driving_license_number", nullable = false)
    public String getDriving_license_number() {
        return driving_license_number;
    }

    public void setDriving_license_number(String driving_license_number) {
        this.driving_license_number = driving_license_number;
    }

    @Column(name = "driving_license_expire_date", nullable = false)
    public String getDriving_license_expire_date() {
        return driving_license_expire_date;
    }

    public void setDriving_license_expire_date(String driving_license_expire_date) {
        this.driving_license_expire_date = driving_license_expire_date;
    }

    @Column(name = "driving_license_issue_place", nullable = false)
    public String getDriving_license_issue_place() {
        return driving_license_issue_place;
    }

    public void setDriving_license_issue_place(String driving_license_issue_place) {
        this.driving_license_issue_place = driving_license_issue_place;
    }

    @Column(name = "driving_license_document_img", nullable = false)
    public String getDriving_license_document_img() {
        return driving_license_document_img;
    }

    public void setDriving_license_document_img(String driving_license_document_img) {
        this.driving_license_document_img = driving_license_document_img;
    }

    @Override
    public String toString() {
        return "DrivingLicense{" +
                "id=" + id +
                ", person_id=" + person_id +
                ", driving_license_number='" + driving_license_number + '\'' +
                ", driving_license_expire_date='" + driving_license_expire_date + '\'' +
                ", driving_license_issue_place='" + driving_license_issue_place + '\'' +
                ", driving_license_document_img='" + driving_license_document_img + '\'' +
                '}';
    }
}
