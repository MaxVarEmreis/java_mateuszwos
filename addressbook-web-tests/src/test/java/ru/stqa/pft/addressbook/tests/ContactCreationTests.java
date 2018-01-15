package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/stru.png");
    ContactData contact = new ContactData().withFirtsName("test_first_name").withLastName("test_last_name")
            .withMobile("test_mobile").withEmail("test_email").withPhoto(photo);
    app.goTo().contactPage();
    app.contact().create(contact);
    assertThat(app.contact().count(),  equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }

}
