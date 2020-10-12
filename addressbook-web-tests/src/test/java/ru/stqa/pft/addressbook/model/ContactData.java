package ru.stqa.pft.addressbook.model;

import com.github.javafaker.Faker;

import java.util.Objects;

public class ContactData {
    public static Faker faker = new Faker();

    private int id = Integer.MAX_VALUE;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String emailAddress;
    private String phoneNumber;
    private String group;

    public int getId() {
        return id;
    }

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

    public ContactData withEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
        return this;
    }

    public ContactData withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getGroup() {
        return group;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "id='" + id + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", streetAddress='" + streetAddress + '\'' +
                ", emailAddress='" + emailAddress + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id &&
                Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(streetAddress, that.streetAddress) &&
                Objects.equals(emailAddress, that.emailAddress) &&
                Objects.equals(phoneNumber, that.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, streetAddress, emailAddress, phoneNumber);
    }
} // fixme добавить параметров
