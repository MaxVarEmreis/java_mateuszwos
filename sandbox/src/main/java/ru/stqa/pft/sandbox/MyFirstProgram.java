package ru.stqa.pft.sandbox;

import com.sun.org.apache.xpath.internal.SourceTree;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Alexei");

    Square s = new Square(5);
    System.out.println("Powierzchnia o boku " + s.l + " = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Powierzchnia prostokąta o boku " + r.a + " i " + r.b + " = " + r.area());

    Point p1 = new Point(3.2, 2.3);
    Point p2 = new Point(4.1, 1.1);
    System.out.println("Odległość pomiędzy punktem (" + p1.x + " , " + p1.y + ") a punktem (" + p2.x + " , " + p2.y + " ) wynosi " + p1.distance(p2));

  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }


}