package ru.stqa.pft.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Alexei");

    double l = 5;
    System.out.println("Powierzchnia o boku " + l + " = " + area(l));

    double a = 4;
    double b = 6;
    System.out.println("Powierzchnia prostokąta o boku " + a + " i " + b + " = " + area(a, b));

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double area(double len) {
    return len * len;

  }

  public static double area(double a, double b) {


    return a * b;
  }
}