package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {

    @Test
    public void testContactCreation() {
        app.getContactHelper().initContactCreation();
        app.getContactHelper().fillContactForm(new ContactData("Alex", "N", "Bogdanov", "ironweed", "QA", "EFO", "SPb, Zvenigorodskaya st, 20", "321456987", "mail@mail.ru"));
        app.getContactHelper().submitContactCreation();
        app.getNavigationHelper().goToHomePage();
        app.getSessionHelper().logout();
    }
}
