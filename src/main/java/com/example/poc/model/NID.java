package com.example.poc.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "nid")
public class NID implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private long person_id;
    private Long nid_number;
    private String nid_document_img;

    public NID(){

    }

    public NID(long person_id, long nid_number){
        this.person_id = person_id;
        this.nid_number = nid_number;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "person_id", nullable = false)
    public long getPerson_id() {
        return person_id;
    }

    public void setPerson_id(Long person_id) {
        this.person_id = person_id;
    }

    @Column(name = "nid_number", nullable = false)
    public long getNid_number() {
        return nid_number;
    }

    public void setNid_number(long nid_number) {
        this.nid_number = nid_number;
    }

    @Column(name = "nid_document_img")
    public String getNid_document_img() {
        return nid_document_img;
    }

    public void setNid_document_img(String nid_document_img) {
        this.nid_document_img = nid_document_img;
    }

    @Override
    public String toString() {
        return "NID{" +
                "id=" + id +
                ", person_id=" + person_id +
                ", nid_number=" + nid_number +
                ", nid_document_img='" + nid_document_img + '\'' +
                '}';
    }
}
