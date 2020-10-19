package ru.stqa.pft.addressbook.model;

import com.github.javafaker.Faker;

import java.util.Objects;

public class ContactData {
    public static Faker faker = new Faker();

    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String homePhoneNumber;
    private String mobilePhoneNumber;
    private String workPhoneNumber;
    private String email;
    private String email2;
    private String email3;

    private String allPhones;
    private String allEmails;

    private String group;



    public ContactData withId(int id) {
        this.id = id;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
        return this;
    }


    public ContactData withHomePhoneNumber(String homePhoneNumber) {
        this.homePhoneNumber = homePhoneNumber;
        return this;
    }

    public ContactData withMobilePhoneNumber(String mobilePhoneNumber) {
        this.mobilePhoneNumber = mobilePhoneNumber;
        return this;
    }

    public ContactData withWorkPhoneNumber(String workPhoneNumber) {
        this.workPhoneNumber = workPhoneNumber;
        return this;
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactData withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public ContactData withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public ContactData withAllEmails(String allEmails) {
        this.allEmails = allEmails;
        return this;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }
    public String getStreetAddress() {
        return streetAddress;
    }
    public String getHomePhoneNumber() { return homePhoneNumber; }
    public String getMobilePhoneNumber() {
        return mobilePhoneNumber;
    }
    public String getWorkPhoneNumber() {
        return workPhoneNumber;
    }
    public String getEmail() { return email; }
    public String getEmail2() { return email2; }
    public String getEmail3() { return email3; }
    public String getAllEmails() { return allEmails; }
    public String getAllPhones() { return allPhones; }
    public String getGroup() {return group;}
    public int getId() { return id; }

    @Override
    public String toString() {
        return "ContactData{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName);
    }


} // fixme добавить параметров
