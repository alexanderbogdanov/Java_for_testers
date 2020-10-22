package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeletionTests extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size()==0) {
            app.contact().create(new ContactData()
                    .withLastName("Bogdanov")
                    .withFirstName("Alex")
                    .withStreetAddress("lenina 2")
                    .withEmail("mail1@mail.ru")
                    .withEmail2("mail2@mail.ru")
                    .withEmail3("mail3@mail.ru")
                    .withHomePhoneNumber("3216798")
                    .withMobilePhoneNumber("89113211223")
                    .withWorkPhoneNumber("2465478")
                    .withGroup("text1"));
        }
        app.goTo().homePage();
    }


    @Test(enabled = true)
    public void testContactDeletion() throws Exception {
        Contacts before = app.db().contacts();
        ContactData deletedContact = before.iterator().next();
        app.contact().delete(deletedContact);
        assertThat(app.contact().count(), equalTo(before.size() - 1));
        Contacts after = app.db().contacts();
        assertThat(after, equalTo(before.without(deletedContact)));
    }
}
