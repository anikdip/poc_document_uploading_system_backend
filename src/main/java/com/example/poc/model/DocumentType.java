package com.example.poc.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Entity
@Table(name = "document_type")
public class DocumentType implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private long id;
    @Column(name = "type", nullable = false)
    public String type;

//    @OneToMany(mappedBy="documentType", cascade = CascadeType.ALL)
//    List<DocumentTypeFields> documentTypeFields;

    public DocumentType(){}

    public DocumentType(String type) {
        this.type = type;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    @Column(name = "type", nullable = false)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

//    public List<DocumentTypeFields> getDocumentTypeFields() {
//        return documentTypeFields;
//    }
//
//    public void setDocumentTypeFields(List<DocumentTypeFields> documentTypeFields) {
//        this.documentTypeFields = documentTypeFields;
//    }

    @Override
    public String toString() {
        return "DocumentType{" +
                "id=" + id +
                ", type='" + type + '\'' +
//                ", documentTypeFields=" + documentTypeFields +
                '}';
    }
}
