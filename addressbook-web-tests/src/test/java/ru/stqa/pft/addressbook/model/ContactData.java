package ru.stqa.pft.addressbook.model;

public class ContactData {
  private final String firtsName;
  private final String lastName;
  private final String mobile;
  private final String email;
  private String group;

  public ContactData(String firtsName, String lastName, String mobile, String email, String group) {
    this.firtsName = firtsName;
    this.lastName = lastName;
    this.mobile = mobile;
    this.email = email;
    this.group = group;
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

  public String getGroup() {
    return group;
  }
}
