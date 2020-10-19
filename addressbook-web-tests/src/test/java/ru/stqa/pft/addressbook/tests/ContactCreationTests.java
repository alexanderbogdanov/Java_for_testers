package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

    @Test(enabled = true)
    public void testContactCreation() {
        Contacts before = (Contacts) app.contact().all();
        ContactData contact = new ContactData()
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
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
    }

    @Test(enabled = false)
    public void testBadContactCreation() {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData()
                .withLastName("o'brien")
                .withFirstName(ContactData.faker.name().firstName())
                .withStreetAddress(ContactData.faker.address().streetAddress())
                .withEmail(ContactData.faker.internet().emailAddress())
                .withEmail2(ContactData.faker.internet().emailAddress())
                .withEmail3(ContactData.faker.internet().emailAddress())
                .withHomePhoneNumber(ContactData.faker.number().digits(7))
                .withMobilePhoneNumber(ContactData.faker.number().digits(11))
                .withWorkPhoneNumber(ContactData.faker.number().digits(7))
                .withGroup("text1");
        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size()));
        Contacts after = app.contact().all();
        assertThat(after, equalTo(
                before));
    }}

