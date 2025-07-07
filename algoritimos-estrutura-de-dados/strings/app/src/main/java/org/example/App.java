package org.example;

import java.util.Arrays;
import java.util.List;

public class App {
  public static void main(String[] args) {
    exampleIndexOf();
  }

  public static void exampleIndexOf() {
    // int indexOf(int ch) for characted
    // int indexOf(String str) for substring
    // int indexOf(int ch, int fromIndex)
    // int indexOf(String str, int fromIndex)

    String text = "Hello world";

    int pos1 = text.indexOf('w');
    int pos2 = text.indexOf("wor");
    int pos3 = text.indexOf("x"); // rerturn -1 beacause the letter x not exist
    int pos4 = text.indexOf('o', 5); // return 7 (second 'o')

    System.out.println(pos1);
    System.out.println(pos2);
    System.out.println(pos3);
    System.out.println(pos4);

    List<String> fruits = Arrays.asList("apple", "banana", "cherry", "apple");

    int pos = fruits.indexOf("apple"); // return first apple (0)

    System.out.println(pos);
  }
}
