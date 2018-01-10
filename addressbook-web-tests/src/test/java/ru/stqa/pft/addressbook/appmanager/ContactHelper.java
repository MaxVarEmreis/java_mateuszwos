package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoHomePage() {
    click(By.linkText("home page"));
  }

  public void enterContact() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getFirtsName());
    type(By.name("lastname"), contactData.getLastName());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getEmail());

    if (creation) {
      new Select(wd. findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
      } else {
        Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
  }

  public void modify(ContactData contact) {
    selectContact(0);
    fillContactForm(contact, false);
    updateContactForm();
    contactCache = null;
    gotoHomePage();
  }

  public void selectContact(int index) {
    wd.findElements(By.xpath("//div/div[4]/form[2]/table/tbody/tr[2]/td[8]/a/img")).get(index).click();

  }

  public void deletion(int index) {
    checkboxSelectContact(index);
    deleteContact();
    alertDeletion();
  }

  public void deletion(ContactData contact) {
    checkboxSelectContactById(contact.getId());
    deleteContact();
    contactCache = null;
    alertDeletion();
  }

  public void updateContactForm() {
    click(By.name("update"));
  }

  public void deleteContact() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void checkboxSelectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
  }

  public void checkboxSelectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id +"']")).click();
  }

  public void alertDeletion() {
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact) {
    fillContactForm(contact, true);
    enterContact();
    contactCache = null;
    gotoHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  //public List<ContactData> list() {
      //List<ContactData> contacts = new ArrayList<ContactData>();
      //List<WebElement> elements = wd.findElements(By.name("entry"));
    //for (WebElement element : elements) {
      //List<WebElement> cells = element.findElements(By.tagName("td"));
     // String firtsName = cells.get(2).getText();
      //String lastName = cells.get(1).getText();
     // int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
     // contacts.add(new ContactData().withId(id).withFirtsName(firtsName).withLastName(lastName));
   // }
   // return contacts;
 // }

  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }
    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String firtsName = cells.get(2).getText();
      String lastName = cells.get(1).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirtsName(firtsName).withLastName(lastName));
    }
    return new Contacts(contactCache);
  }


}
