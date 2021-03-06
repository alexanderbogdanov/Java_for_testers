package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactModificationTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.contact().create(new ContactData()
                    .withLastName(ContactData.faker.name().lastName())
                    .withFirstName(ContactData.faker.name().firstName())
                    .withStreetAddress(ContactData.faker.address().streetAddress())
                    .withEmail(ContactData.faker.internet().emailAddress())
                    .withEmail2(ContactData.faker.internet().emailAddress())
                    .withEmail3(ContactData.faker.internet().emailAddress())
                    .withHomePhoneNumber(ContactData.faker.number().digits(7))
                    .withMobilePhoneNumber(ContactData.faker.number().digits(11))
                    .withWorkPhoneNumber(ContactData.faker.number().digits(7))
                    .withGroup("text1"));
        }
    }

    @Test(enabled = true)
    public void testContactModification() throws Exception {

        app.goTo().homePage(); // ?
        Contacts before = app.db().contacts();
        ContactData modifiedContact = before.iterator().next();
        ContactData contact = new ContactData()
                .withId(modifiedContact.getId())
                .withLastName(ContactData.faker.name().lastName())
                .withFirstName(ContactData.faker.name().firstName())
                .withStreetAddress(ContactData.faker.address().streetAddress())
                .withEmail(ContactData.faker.internet().emailAddress())
                .withEmail2(ContactData.faker.internet().emailAddress())
                .withEmail3(ContactData.faker.internet().emailAddress())
                .withHomePhoneNumber(ContactData.faker.number().digits(7))
                .withMobilePhoneNumber(ContactData.faker.number().digits(11))
                .withWorkPhoneNumber(ContactData.faker.number().digits(7))
                .withGroup("text1");
        app.contact().modify(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(
                before.without(modifiedContact).withAdded(contact)));

    }
}

