package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTests extends TestBase {

    @Test(enabled = true)
    public void testContactCreation() {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData()
                .withLastName(ContactData.faker.name().lastName())
                .withFirstName(ContactData.faker.name().firstName())
                .withStreetAddress(ContactData.faker.address().streetAddress())
                .withEmailAddress(ContactData.faker.internet().emailAddress())
                .withPhoneNumber(ContactData.faker.number().digits(11))
                .withGroup("text1");
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();
        Assert.assertEquals(after.size(), before.size() + 1);
//        contact.setId(after.stream().max(Comparator.comparingInt(ContactData::getId)).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }
}

