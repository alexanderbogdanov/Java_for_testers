package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {

    @Test
    public void testContactModification() throws Exception {
        app.getContactHelper().initContactModification();
        app.getContactHelper().changeName();
        app.getContactHelper().updateContactInfo();
        app.getNavigationHelper().goToHomePage();
        app.getSessionHelper().logout();
    }

}

