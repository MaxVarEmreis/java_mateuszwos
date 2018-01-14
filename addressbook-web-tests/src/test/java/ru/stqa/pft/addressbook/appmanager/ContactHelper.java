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
    initContactModificationById(contact.getId());
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
    String email = wd.findElement(By.name("email")).getAttribute("value");
    String email2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String middlename = wd.findElement(By.name("middlename")).getAttribute("value");
    String nickname = wd.findElement(By.name("nickname")).getAttribute("value");
    String title = wd.findElement(By.name("title")).getAttribute("value");
    String fax = wd.findElement(By.name("fax")).getAttribute("value");
    String company = wd.findElement(By.name("company")).getAttribute("value");
    String homepage = wd.findElement(By.name("homepage")).getAttribute("value");
    String birthdayDay = wd.findElement(By.name("bday")).findElement(By.cssSelector("option[selected=selected]")).getText();
    String birthdayMonth = wd.findElement(By.name("bmonth")).findElement(By.cssSelector("option[selected=selected]")).getText();
    String birthdayYear = wd.findElement(By.name("byear")).getAttribute("value");
    String anniversaryDay = wd.findElement(By.name("aday")).findElement(By.cssSelector("option[selected=selected]")).getText();
    String anniversaryMonth = wd.findElement(By.name("amonth")).findElement(By.cssSelector("option[selected=selected]")).getText();
    String anniversaryYear = wd.findElement(By.name("ayear")).getAttribute("value");
    String secondaryAddress = wd.findElement(By.name("address2")).getAttribute("value");
    String secondaryHomePhone = wd.findElement(By.name("phone2")).getAttribute("value");
    String notes = wd.findElement(By.name("notes")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirtsName(firtsName).withLastName(lastName)
            .withHomePhone(home).withMobile(mobile).withWorkPhone(work).withAddress(address).withEmail(email)
            .withEmail2(email2).withEmail3(email3).withMiddlename(middlename).withNickname(nickname).withTitle(title)
            .withFax(fax).withCompany(company).withHomepage(homepage).withBirthday(birthdayDay+birthdayMonth+birthdayYear)
            .withAnniversary(anniversaryDay+anniversaryMonth+anniversaryYear).withSecondaryAddress(secondaryAddress)
            .withSecondaryHomePhone(secondaryHomePhone).withNotes(notes);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

  public String infoFromDetailsPage (ContactData contact){
    contactDetails(contact);
    WebElement details = wd.findElement(By.id("content"));
    String [] parts = details.getText().split("Member of:");
    String detailsText = parts[0];
    wd.navigate().back();
    return detailsText;
  }

  public void contactDetails (ContactData contact) {
    int id = contact.getId();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int iD = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));
      if (id == iD) {
        cells.get(6).findElement(By.cssSelector("img[title=\"Details\"]")).click();
        return;
      }
    }
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
      String emails = cells.get(4).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withFirtsName(firtsName).withLastName(lastName)
              .withAllPhones(allPhones).withAddress(address).withAllEmails(emails));
    }
    return new Contacts(contactCache);
  }

}
