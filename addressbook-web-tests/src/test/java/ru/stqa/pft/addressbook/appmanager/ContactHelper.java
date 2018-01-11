package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.ContactData;
import ru.stqa.pft.addressbook.model.Contacts;

import java.util.List;

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

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firtsName = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastName = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirtsName(firtsName).withLastName(lastName)
            .withHomePhone(home).withMobile(mobile).withWorkPhone(work).withAddress(address);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
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
      String allPhones = cells.get(5).getText();
      String address = cells.get(3).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirtsName(firtsName).withLastName(lastName)
              .withAllPhones(allPhones).withAddress(address));
    }
    return new Contacts(contactCache);
  }

}
