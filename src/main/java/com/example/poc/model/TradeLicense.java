package com.example.poc.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "trade_license")
public class TradeLicense implements Serializable {
    private static final long serialVersionUID = 1L;

    private long id;
    private long person_id;
    private String trade_license_number;
    private String trade_license_expire_date;
    private String trade_license_issue_place;
    private String trade_license_document_img;

    public TradeLicense(){

    }

    public TradeLicense(long person_id, String trade_license_number, String trade_license_expire_date, String trade_license_issue_place) {
        this.person_id = person_id;
        this.trade_license_number = trade_license_number;
        this.trade_license_expire_date = trade_license_expire_date;
        this.trade_license_issue_place = trade_license_issue_place;
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

    @Column(name = "trade_license_number", nullable = false)
    public String getTrade_license_number() {
        return trade_license_number;
    }

    public void setTrade_license_number(String trade_license_number) {
        this.trade_license_number = trade_license_number;
    }

    @Column(name = "trade_license_expire_date", nullable = false)
    public String getTrade_license_expire_date() {
        return trade_license_expire_date;
    }

    public void setTrade_license_expire_date(String trade_license_expire_date) {
        this.trade_license_expire_date = trade_license_expire_date;
    }

    @Column(name = "trade_license_issue_place", nullable = false)
    public String getTrade_license_issue_place() {
        return trade_license_issue_place;
    }

    public void setTrade_license_issue_place(String trade_license_issue_place) {
        this.trade_license_issue_place = trade_license_issue_place;
    }

    @Column(name = "trade_license_document_img", nullable = false)
    public String getTrade_license_document_img() {
        return trade_license_document_img;
    }

    public void setTrade_license_document_img(String trade_license_document_img) {
        this.trade_license_document_img = trade_license_document_img;
    }

    @Override
    public String toString() {
        return "TradeLicense{" +
                "id=" + id +
                ", person_id=" + person_id +
                ", trade_license_number='" + trade_license_number + '\'' +
                ", trade_license_expire_date='" + trade_license_expire_date + '\'' +
                ", trade_license_issue_place='" + trade_license_issue_place + '\'' +
                ", trade_license_document_img='" + trade_license_document_img + '\'' +
                '}';
    }
}
