package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactDeletionTests extends TestBase {

  @Test
  public void testContactDeletion() {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getNavigationHelper().gotoContactPage();
      app.getContactHelper().createContact(new ContactData("test_first_name", "test_last_name", "test_mobile", "test_email", "test1"));
    }
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().checkboxSelectContact(before - 1);
    app.getContactHelper().deleteContact();
    app.getContactHelper().alertDeletion();
    app.getNavigationHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before - 1);

  }


}
