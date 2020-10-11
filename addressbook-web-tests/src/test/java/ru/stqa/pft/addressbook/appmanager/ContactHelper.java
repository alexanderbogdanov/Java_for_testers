package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

    public ContactHelper(WebDriver wd) {
        super(wd);
    }

    public void initContactCreation() {
        click(By.linkText("add new"));
    }

    public void fillContactForm(ContactData contactData) {

        type(By.name("lastname"), contactData.getLastName());
        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("address"), contactData.getStreetAddress());
        type(By.name("email"), contactData.getEmailAddress());
        type(By.name("home"), contactData.getPhoneNumber());
        }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }
    public void initContactModification(int index) {
        wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
    }

    public void updateContactInfo() {
        click(By.name("update"));
    }

    public void deleteSelectedContact() {
        click(By.xpath("//input[@value='Delete']"));
    }

    public void create(ContactData contact) {
       initContactCreation();
       fillContactForm(contact);
       submitContactCreation();
       returnToHomePage();
    }
    public void modify(int index, ContactData contact) {
//       selectContact(index);
       initContactModification(index);
       fillContactForm(contact);
       updateContactInfo();
       returnToHomePage();
    }

    public void delete(int index) {
        selectContact(index);
        deleteSelectedContact();
        closeAlert();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> list() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> td = element.findElements(By.cssSelector("td"));
            WebElement value = td.get(0);
            String lastName = td.get(1).getText();
            String firstName = td.get(2).getText();
            String streetAddress = td.get(3).getText();
            String emailAddress = td.get(4).getText();
            String phoneNumber = td.get(5).getText();
            int id = Integer.parseInt(value.findElement(By.tagName("input")).getAttribute("value"));
//            ContactData contact = new ContactData(id, firstName.getText(), lastName.getText(), null);
            contacts.add(new ContactData()
                    .withId(id)
                    .withLastName(lastName)
                    .withFirstName(firstName)
                    .withStreetAddress(streetAddress)
                    .withEmailAddress(emailAddress)
                    .withPhoneNumber(phoneNumber));
        }
        return contacts;
    }
}
