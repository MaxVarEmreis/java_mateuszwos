package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firtsName;
  private final String lastName;
  private final String mobile;
  private final String email;

  public ContactData(String firtsName, String lastName, String mobile, String email) {
    this.firtsName = firtsName;
    this.lastName = lastName;
    this.mobile = mobile;
    this.email = email;
  }

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
}
