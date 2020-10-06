package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() throws Exception {
    if(! app.getContactHelper().isThereAContact()){
      app.getContactHelper().createContact(new ContactData("Alex", "Bogdanov", "text1"));
    }
    app.getNavigationHelper().goToHomePage();
    int before = app.getContactHelper().getContactCount();

    app.getContactHelper().selectContact();
    app.getContactHelper().deleteSelectedContact();
    app.closeAlert();
    app.getNavigationHelper().goToHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before -1);

    app.getSessionHelper().logout();
  }
}
