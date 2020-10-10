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

        type(By.name("firstname"), contactData.getFirstName());
        type(By.name("lastname"), contactData.getLastName());
        }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void selectContact(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void returnToHomePage() {
        click(By.linkText("home page"));
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

    public void createContact(ContactData contact) {
       initContactCreation();
       fillContactForm(contact);
       submitContactCreation();
       returnToHomePage();
    }
    public void modifyContact(int index, ContactData contact) {
//       selectContact(index);
       initContactModification(index);
       fillContactForm(contact);
       updateContactInfo();
       returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactData> getContactList() {
        List<ContactData> contacts = new ArrayList<>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            List<WebElement> td = element.findElements(By.cssSelector("td"));
            String lastName = td.get(1).getText();
            String firstName = td.get(2).getText();
            WebElement value = td.get(0);
            int id = Integer.parseInt(value.findElement(By.tagName("input")).getAttribute("value"));
//            ContactData contact = new ContactData(id, firstName.getText(), lastName.getText(), null);
            ContactData contact = new ContactData(id, firstName, lastName, null);
            contacts.add(contact);
        }
        return contacts;
    }
}
