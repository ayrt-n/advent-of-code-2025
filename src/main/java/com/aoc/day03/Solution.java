package com.aoc.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// 17324
public class Solution {
  public static void main(String[] args) {
    long code = 0;

    try(BufferedReader reader = Files.newBufferedReader(Paths.get("inputs/day03.txt"))) {
      String line;

      while((line = reader.readLine()) != null) {
        Bank bank = new Bank(line);
        code += bank.maximumJoltage(12);
      }
    } catch (IOException e) {
      System.out.println("There was an error while trying to read from the day03 input");
      return;
    }

    System.out.println("The code is " + code);
  }
}
