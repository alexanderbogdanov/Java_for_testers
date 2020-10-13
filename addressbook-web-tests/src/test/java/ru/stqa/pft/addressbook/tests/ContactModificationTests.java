package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.contact().all().size() == 0) {
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
        Contacts before = app.contact().all();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withLastName(ContactData.faker.name().lastName())
                .withFirstName(ContactData.faker.name().firstName())
                .withStreetAddress(ContactData.faker.address().streetAddress())
                .withEmailAddress(ContactData.faker.internet().emailAddress())
                .withPhoneNumber(ContactData.faker.number().digits(11));
        app.contact().modify(contact);
        Contacts after = app.contact().all();
        assertEquals(after.size(), (before.size()));
        assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));

    }
}

