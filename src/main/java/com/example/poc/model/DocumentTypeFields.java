package com.example.poc.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "document_type_fields")
public class DocumentTypeFields implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    @Column(name = "document_type_id", nullable = false)
    private long document_type_id;
    @Column(name="field_name", nullable=false)
    private String field_name;
    @Column(name = "field_type", nullable = false)
    private String field_type;

    public DocumentTypeFields(){}

    public DocumentTypeFields(long document_type_id, String field_name, String field_type) {
        this.document_type_id = document_type_id;
        this.field_name = field_name;
        this.field_type = field_type;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDocument_type_id() {
        return document_type_id;
    }

    public void setDocument_type_id(long document_type_id) {
        this.document_type_id = document_type_id;
    }

    public String getField_type() {
        return field_type;
    }

    public void setField_type(String field_type) {
        this.field_type = field_type;
    }

    public String getField_name() {
        return field_name;
    }

    public void setField_name(String field_name) {
        this.field_name = field_name;
    }

    @Override
    public String toString() {
        return "DocumentTypeFields{" +
                "id=" + id +
                ", document_type_id=" + document_type_id +
                ", field_name='" + field_name + '\'' +
                ", field_type='" + field_type + '\'' +
                '}';
    }
}
