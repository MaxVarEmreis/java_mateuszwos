package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String firtsName;
  private String lastName;
  private String mobile;
  private String email;
  private String group;
  private String homePhone;
  private String workPhone;
  private String allPhones;
  private String address;
  private String email2;
  private String email3;
  private String allEmails;
  private String middlename;
  private String nickname;
  private String title;
  private String fax;
  private String company;
  private String homepage;
  private String birthday;
  private String birthdayDay;
  private String birthdayMonth;
  private String birthdayYear;
  private String anniversary;
  private String anniversaryDay;
  private String anniversaryMonth;
  private String anniversaryYear;
  private String secondaryAddress;
  private String secondaryHomePhone;
  private String notes;





  public String getFirtsName() {
    return firtsName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getMobile() {
    return mobile;
  }

  public String getEmail() {
    return email;
  }

  public String getGroup() {
    return group;
  }

  public String getHomePhone() {
    return homePhone;
  }

  public String getWorkPhone() {
    return workPhone;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public String getAddress() {
    return address;
  }

  public String getEmail2() {
    return email2;
  }


  public String getEmail3() {
    return email3;
  }


  public String getAllEmails() {
    return allEmails;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getNickname() {
    return nickname;
  }

  public String getTitle() {
    return title;
  }

  public String getFax() {
    return fax;
  }

  public String getCompany() {
    return company;
  }


  public String getHomepage() {
    return homepage;
  }

  public String getBirthday() {
    return birthday;
  }


  public String getBirthdayDay() {
    return birthdayDay;
  }

  public String getBirthdayMonth() {
    return birthdayMonth;
  }

  public String getBirthdayYear() {
    return birthdayYear;
  }

  public String getAnniversary() {
    return anniversary;
  }

  public String getAnniversaryDay() {
    return anniversaryDay;
  }

  public String getAnniversaryMonth() {
    return anniversaryMonth;
  }

  public String getAnniversaryYear() {
    return anniversaryYear;
  }

  public String getSecondaryAddress() {
    return secondaryAddress;
  }

  public String getSecondaryHomePhone() {
    return secondaryHomePhone;
  }

  public String getNotes() {
    return notes;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "id='" + id + '\'' +
            ", firtsName='" + firtsName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  public int getId() {
    return id;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(firtsName, that.firtsName) &&
            Objects.equals(lastName, that.lastName);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, firtsName, lastName);
  }

  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withFirtsName(String firtsName) {
    this.firtsName = firtsName;
    return this;
  }

  public ContactData withLastName(String lastName) {
    this.lastName = lastName;
    return this;
  }

  public ContactData withMobile(String mobile) {
    this.mobile = mobile;
    return this;
  }

  public ContactData withEmail(String email) {
    this.email = email;
    return this;
  }

  public ContactData withGroup(String group) {
    this.group = group;
    return this;
  }

  public ContactData withWorkPhone(String workPhone) {
    this.workPhone = workPhone;
    return this;
  }

  public ContactData withHomePhone(String homePhone) {
    this.homePhone = homePhone;
    return this;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public ContactData withAddress(String address) {
    this.address = address;
    return this;
  }

  public ContactData withEmail2(String email2) {
    this.email2 = email2;
    return this;
  }

  public ContactData withEmail3(String email3) {
    this.email3 = email3;
    return this;
  }

  public ContactData withAllEmails(String allEmails) {
    this.allEmails = allEmails;
    return this;
  }

  public ContactData withMiddlename(String middlename) {
    this.middlename = middlename;
    return this;
  }

  public ContactData withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public ContactData withTitle(String title) {
    this.title = title;
    return this;
  }

  public ContactData withFax(String fax) {
    this.fax = fax;
    return this;
  }

  public ContactData withCompany(String company) {
    this.company = company;
    return this;
  }

  public ContactData withHomepage(String homepage) {
    this.homepage = homepage;
    return this;
  }

  public ContactData withBirthday(String birthday) {
    this.birthday = birthday;
    return this;
  }

  public ContactData withBirthdayDay(String birthdayDay) {
    this.birthdayDay = birthdayDay;
    return this;
  }

  public ContactData withBirthdayMonth(String birthdayMonth) {
    this.birthdayMonth = birthdayMonth;
    return this;
  }

  public ContactData withBirthdayYear(String birthdayYear) {
    this.birthdayYear = birthdayYear;
    return this;
  }

  public ContactData withAnniversary(String anniversary) {
    this.anniversary = anniversary;
    return this;
  }

  public ContactData withAnniversaryDay(String anniversaryDay) {
    this.anniversaryDay = anniversaryDay;
    return this;
  }

  public ContactData withAnniversaryMonth(String anniversaryMonth) {
    this.anniversaryMonth = anniversaryMonth;
    return this;
  }

  public ContactData withAnniversaryYear(String anniversaryYear) {
    this.anniversaryYear = anniversaryYear;
    return this;
  }

  public ContactData withSecondaryAddress(String secondaryAddress) {
    this.secondaryAddress = secondaryAddress;
    return this;
  }

  public ContactData withSecondaryHomePhone(String secondaryHomePhone) {
    this.secondaryHomePhone = secondaryHomePhone;
    return this;
  }

  public ContactData withNotes(String notes) {
    this.notes = notes;
    return this;
  }

}

