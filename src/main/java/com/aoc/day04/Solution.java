package com.aoc.day04;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    List<String> paperList = new ArrayList<>();
    
    try (BufferedReader reader = Files.newBufferedReader(Paths.get("inputs/day04.txt"))) {
      String line;

      while ((line = reader.readLine()) != null) {
        paperList.add(line);
      }
    } catch (IOException e) {
      System.out.println("There was an error while trying to read from the day04 input");
      return;
    }

    PaperRolls paperRolls = new PaperRolls(paperList);
    System.out.println("The code is " + paperRolls.accessible());
  }
}
