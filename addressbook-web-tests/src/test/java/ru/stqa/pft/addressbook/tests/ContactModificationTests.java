package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.GroupData;

import java.util.Comparator;
import java.util.List;
import java.util.Set;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().list().size() == 0) {
            app.contact().create(new ContactData()
                    .withLastName(ContactData.faker.name().lastName())
                    .withFirstName(ContactData.faker.name().firstName())
                    .withStreetAddress(ContactData.faker.address().streetAddress())
                    .withEmailAddress(ContactData.faker.internet().emailAddress())
                    .withPhoneNumber(ContactData.faker.number().digits(11))
                    .withGroup("text1"));
        }
    }

    @Test(enabled = true)
    public void testContactModification() throws Exception {

        app.goTo().homePage(); // ?
        Set<ContactData> before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withLastName(ContactData.faker.name().lastName())
                .withFirstName(ContactData.faker.name().firstName())
                .withStreetAddress(ContactData.faker.address().streetAddress())
                .withEmailAddress(ContactData.faker.internet().emailAddress())
                .withPhoneNumber(ContactData.faker.number().digits(11));
        app.contact().modify(contact);
        Set<ContactData> after = app.contact().all();
        Assert.assertEquals(after.size(), before.size());

        before.remove(modifiedContact);
        before.add(contact);
        Assert.assertEquals(before, after);
    }
}

