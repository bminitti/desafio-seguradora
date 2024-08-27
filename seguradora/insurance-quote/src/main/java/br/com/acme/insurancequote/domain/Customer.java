package br.com.acme.insurancequote.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;


public class Customer implements Serializable  {

    @JsonProperty("document_number")
    private String documentNumber;

    @JsonProperty("name")
    private String name;

    @JsonProperty("type")
    private String type;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("date_of_bith")
    private String dateOfBirth;

    @JsonProperty("email")
    private String email;

    @JsonProperty("phone_number")
    private String phoneNumber;

    public Customer(){

    }

    public Customer(String documentNumber, String name, String type, String gender, String dateOfBirth, String email, String phoneNumber) {
        this.documentNumber = documentNumber;
        this.name = name;
        this.type = type;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
