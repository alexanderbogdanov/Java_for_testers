package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        type(By.name("email"), contactData.getEmail());
        type(By.name("email2"), contactData.getEmail2());
        type(By.name("email3"), contactData.getEmail3());
        type(By.name("home"), contactData.getHomePhoneNumber());
        type(By.name("mobile"), contactData.getMobilePhoneNumber());
        type(By.name("work"), contactData.getWorkPhoneNumber());
        }

    public void submitContactCreation() {
        click(By.name("submit"));
    }

    public void selectContactById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void returnToHomePage() {
        click(By.linkText("home"));
    }

/*    public void initContactModification(int id) {
    //        wd.findElement(By.xpath("//a[contains(@href, 'edit.php?id=" + id + "')]")).click();
        wd.findElement(By.cssSelector(String.format("a[href='edit.php&id=%s']", id))).click();
    }*/

    public void initContactModification() {
        click(By.cssSelector("img[alt='Edit']"));
    }

    public void initContactModificationById(int id) {
        wd.findElement(By.xpath("//a[contains(@href, 'edit.php?id=" + id + "')]")).click();

//        wd.findElement(By.cssSelector(String.format("a[href='edit.php&id=%s']", id))).click();
    }

    public ContactData infoFromEditForm(ContactData contact) {

        initContactModificationById(contact.getId());
        String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
        String firstName = wd.findElement(By.name("firstname")).getAttribute("value");
        String streetAddress = wd.findElement(By.name("address")).getAttribute("value");
        String homePhoneNumber = wd.findElement(By.name("home")).getAttribute("value");
        String mobilePhoneNumber = wd.findElement(By.name("mobile")).getAttribute("value");
        String workPhoneNumber = wd.findElement(By.name("work")).getAttribute("value");
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactData()
                .withId(contact.getId())
                .withLastName(lastName)
                .withFirstName(firstName)
                .withStreetAddress(streetAddress)
                .withEmail(email)
                .withEmail2(email2)
                .withEmail3(email3)
                .withHomePhoneNumber(homePhoneNumber)
                .withMobilePhoneNumber(mobilePhoneNumber)
                .withWorkPhoneNumber(workPhoneNumber)
                .withGroup("text1");
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

    public void modify(ContactData contact) {
        initContactModificationById(contact.getId());
        fillContactForm(contact);
        updateContactInfo();
        returnToHomePage();
    }

    public void delete(ContactData contact) {
        selectContactById(contact.getId());
        deleteSelectedContact();
        closeAlert();
        returnToHomePage();
    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }



    public Contacts all() {
//    public Set<ContactData> all() {
        Contacts contacts = new Contacts();
//        Set<ContactData> contacts = new HashSet<>();
        List<WebElement> rows = wd.findElements(By.name("entry"));
        for (WebElement row : rows) {
            List<WebElement> cells = row.findElements(By.tagName("td"));
            int id = Integer.parseInt(cells.get(0).findElement(
                    By.tagName("input")).getAttribute("value"));
            String lastName = cells.get(1).getText();
            String firstName = cells.get(2).getText();
            String streetAddress = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            String allPhones = cells.get(5).getText();
            contacts.add(new ContactData()
                    .withId(id)
                    .withLastName(lastName)
                    .withFirstName(firstName)
                    .withStreetAddress(streetAddress)
                    .withAllEmails(allEmails)
                    .withAllPhones(allPhones)
                    .withGroup("text1"));
        }
        return contacts;
    }

}
