package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTests extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    File photo = new File("src/test/resources/stru.png");
    list.add(new Object[]{new ContactData().withFirtsName("firtsName 1").withLastName("lastName 1")
            .withMobile("mobile 1").withEmail("email 1").withPhoto(photo)});
    list.add(new Object[]{new ContactData().withFirtsName("firtsName 2").withLastName("lastName 2")
            .withMobile("mobile 2").withEmail("email 2").withPhoto(photo)});
    list.add(new Object[]{new ContactData().withFirtsName("firtsName 3").withLastName("lastName 3")
            .withMobile("mobile 3").withEmail("email 3").withPhoto(photo)});
    return list.iterator();
  }


  @Test(dataProvider = "validContacts")
  public void testContactCreation(ContactData contact) {
    app.goTo().homePage();
    Contacts before = app.contact().all();
    app.goTo().contactPage();
    app.contact().create(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));
  }
}

