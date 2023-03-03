package gov.myjavaprojects.clientorder.domain;

import java.time.LocalDate;

public abstract class Person {
    private String sureName;
    private String givenName;
    private String patronymic;
    private LocalDate dateOfbirth;
    private Address address;

    public Person()
    {

    }

    public Person(String sureName, String givenName, String patronymic, LocalDate dateOfbirth) {
        this.sureName = sureName;
        this.givenName = givenName;
        this.patronymic = patronymic;
        this.dateOfbirth = dateOfbirth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSureName() {
        return sureName;
    }

    public void setSureName(String sureName) {
        this.sureName = sureName;
    }

    public String getGivenName() {
        return givenName;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public LocalDate getDateOfbirth() {
        return dateOfbirth;
    }

    public void setDateOfbirth(LocalDate dateOfbirth) {
        this.dateOfbirth = dateOfbirth;
    }



}
