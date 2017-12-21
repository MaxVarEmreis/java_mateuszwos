package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase {

  @Test
  public void testContactModification() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoContactPage();
      app.getContactHelper().createContact(new ContactData("test_first_name", "test_last_name", "test_mobile", "test_email", "test1"));
    }
    app.getContactHelper().selectContact();
    app.getContactHelper().fillContactForm(new ContactData("test_first_name", "test_last_name", "test_mobile", "test_email", null), false);
    app.getContactHelper().updateContactForm();
    app.getContactHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before);

  }
}
