package com.example.poc.model;

public class PersonInfo {
    private String firstName;
    private String lastName;
    private String emailId;
    private String birthdate;
    private String fathername;
    private String mothername;
    private long mobileno;
    private long nid_number;
    private String nid_document_img;
    private String driving_license_number;
    private String driving_license_expire_date;
    private String driving_license_issue_place;
    private String driving_license_document_img;
    private String trade_license_number;
    private String trade_license_expire_date;
    private String trade_license_issue_place;
    private String trade_license_document_img;

    public PersonInfo(){}

    public PersonInfo(String firstName, String lastName, String emailId, String birthdate, String fathername, String mothername, long mobileno, long nid_number, String nid_document_img, String driving_license_number, String driving_license_expire_date, String driving_license_issue_place, String driving_license_document_img, String trade_license_number, String trade_license_expire_date, String trade_license_issue_place, String trade_license_document_img) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailId = emailId;
        this.birthdate = birthdate;
        this.fathername = fathername;
        this.mothername = mothername;
        this.mobileno = mobileno;
        this.nid_number = nid_number;
        this.nid_document_img = nid_document_img;
        this.driving_license_number = driving_license_number;
        this.driving_license_expire_date = driving_license_expire_date;
        this.driving_license_issue_place = driving_license_issue_place;
        this.driving_license_document_img = driving_license_document_img;
        this.trade_license_number = trade_license_number;
        this.trade_license_expire_date = trade_license_expire_date;
        this.trade_license_issue_place = trade_license_issue_place;
        this.trade_license_document_img = trade_license_document_img;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getFathername() {
        return fathername;
    }

    public void setFathername(String fathername) {
        this.fathername = fathername;
    }

    public String getMothername() {
        return mothername;
    }

    public void setMothername(String mothername) {
        this.mothername = mothername;
    }

    public long getMobileno() {
        return mobileno;
    }

    public void setMobileno(long mobileno) {
        this.mobileno = mobileno;
    }

    public long getNid_number() {
        return nid_number;
    }

    public void setNid_number(long nid_number) {
        this.nid_number = nid_number;
    }

    public String getNid_document_img() {
        return nid_document_img;
    }

    public void setNid_document_img(String nid_document_img) {
        this.nid_document_img = nid_document_img;
    }

    public String getDriving_license_number() {
        return driving_license_number;
    }

    public void setDriving_license_number(String driving_license_number) {
        this.driving_license_number = driving_license_number;
    }

    public String getDriving_license_expire_date() {
        return driving_license_expire_date;
    }

    public void setDriving_license_expire_date(String driving_license_expire_date) {
        this.driving_license_expire_date = driving_license_expire_date;
    }

    public String getDriving_license_issue_place() {
        return driving_license_issue_place;
    }

    public void setDriving_license_issue_place(String driving_license_issue_place) {
        this.driving_license_issue_place = driving_license_issue_place;
    }

    public String getDriving_license_document_img() {
        return driving_license_document_img;
    }

    public void setDriving_license_document_img(String driving_license_document_img) {
        this.driving_license_document_img = driving_license_document_img;
    }

    public String getTrade_license_number() {
        return trade_license_number;
    }

    public void setTrade_license_number(String trade_license_number) {
        this.trade_license_number = trade_license_number;
    }

    public String getTrade_license_expire_date() {
        return trade_license_expire_date;
    }

    public void setTrade_license_expire_date(String trade_license_expire_date) {
        this.trade_license_expire_date = trade_license_expire_date;
    }

    public String getTrade_license_issue_place() {
        return trade_license_issue_place;
    }

    public void setTrade_license_issue_place(String trade_license_issue_place) {
        this.trade_license_issue_place = trade_license_issue_place;
    }

    public String getTrade_license_document_img() {
        return trade_license_document_img;
    }

    public void setTrade_license_document_img(String trade_license_document_img) {
        this.trade_license_document_img = trade_license_document_img;
    }

    @Override
    public String toString() {
        return "PersonInfo{" +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", emailId='" + emailId + '\'' +
                ", birthdate='" + birthdate + '\'' +
                ", fathername='" + fathername + '\'' +
                ", mothername='" + mothername + '\'' +
                ", mobileno=" + mobileno +
                ", nid_number=" + nid_number +
                ", nid_document_img='" + nid_document_img + '\'' +
                ", driving_license_number='" + driving_license_number + '\'' +
                ", driving_license_expire_date='" + driving_license_expire_date + '\'' +
                ", driving_license_issue_place='" + driving_license_issue_place + '\'' +
                ", driving_license_document_img='" + driving_license_document_img + '\'' +
                ", trade_license_number='" + trade_license_number + '\'' +
                ", trade_license_expire_date='" + trade_license_expire_date + '\'' +
                ", trade_license_issue_place='" + trade_license_issue_place + '\'' +
                ", trade_license_document_img='" + trade_license_document_img + '\'' +
                '}';
    }
}
