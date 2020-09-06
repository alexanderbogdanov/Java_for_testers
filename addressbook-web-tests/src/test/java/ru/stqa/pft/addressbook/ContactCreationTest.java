package ru.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase {

  @Test
  public void testContactCreation() throws Exception {

    initContactCreation();
    fillContactForm(new ContactData("Alex", "N", "Bogdanov", "ironweed", "QA", "EFO", "SPb, Zvenigorodskaya st, 20", "321456987", "mail@mail.ru"));
    submitContactCreation();
    returnToHomePage();
  }
}
