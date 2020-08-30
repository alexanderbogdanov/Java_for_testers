package ru.stqa.pft.addressbook;

public class ContactData {
    private final String firstName;
    private final String middleName;
    private final String surname;
    private final String nickname;
    private final String title;
    private final String company;
    private final String address;
    private final String homeNumber;
    private final String email;

    public ContactData(String firstName, String middleName, String surname, String nickname, String title, String company, String address, String homeNumber, String email) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.surname = surname;
        this.nickname = nickname;
        this.title = title;
        this.company = company;
        this.address = address;
        this.homeNumber = homeNumber;
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getSurname() {
        return surname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getAddress() {
        return address;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public String getEmail() {
        return email;
    }
}
