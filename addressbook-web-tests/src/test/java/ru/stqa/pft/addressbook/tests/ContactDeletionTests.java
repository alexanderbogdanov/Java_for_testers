package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactDeletionTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if(app.contact().list().size() == 0){
      app.contact().create(new ContactData()
              .withLastName("Bogdanov")
              .withFirstName("Alex")
              .withStreetAddress("lenina 2")
              .withEmailAddress("mail@mail.ru")
              .withPhoneNumber("89113211223")
              .withGroup("text1"));
    }
    app.goTo().homePage();
  }


  @Test(enabled = true)
  public void testContactDeletion() throws Exception {
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();

    app.contact().delete(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() -1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);

  }
}
