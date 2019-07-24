package com.example.poc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "person_document_info")
public class PersonDocumentInfo implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;

    @Column(name = "person_id", nullable = false)
    private long person_id;

    @Column(name = "document_type_field_id", nullable = false)
    private long document_type_field_id;

    @Column(name = "value", nullable = false)
    private String value;

    public PersonDocumentInfo(){}

    public PersonDocumentInfo(long person_id, long document_type_field_id, String value) {
        this.person_id = person_id;
        this.document_type_field_id = document_type_field_id;
        this.value = value;
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

    public long getDocument_type_field_id() {
        return document_type_field_id;
    }

    public void setDocument_type_field_id(long document_type_field_id) {
        this.document_type_field_id = document_type_field_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "PersonDocumentInfo{" +
                "id=" + id +
                ", person_id=" + person_id +
                ", document_type_field_id=" + document_type_field_id +
                ", value='" + value + '\'' +
                '}';
    }
}
