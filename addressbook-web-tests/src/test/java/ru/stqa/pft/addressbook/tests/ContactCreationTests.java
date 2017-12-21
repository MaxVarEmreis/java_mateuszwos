package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactCreationTests extends TestBase {


  @Test
  public void testContactCreation() {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getContactHelper().getContactCount();
    app.getNavigationHelper().gotoContactPage();
    app.getContactHelper().fillContactForm(new ContactData("test_first_name", "test_last_name", "test_mobile", "test_email", "test1"), true);
    app.getContactHelper().enterContact();
    app.getContactHelper().gotoHomePage();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before + 1);
  }

}
