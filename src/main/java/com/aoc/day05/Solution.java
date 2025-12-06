package com.aoc.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
  public static void main(String[] args) {
    Ranges ranges = new Ranges();
    int freshIngredients = 0;

    try (BufferedReader reader = Files.newBufferedReader(Paths.get("inputs/day05.txt"))) {
      String line;
      
      while (true) {
        line = reader.readLine();
        if (line == null || line.isEmpty()) break;

        String[] rangeParts = line.split("-");
        long rangeStart = Long.parseLong(rangeParts[0]);
        long rangeEnd = Long.parseLong(rangeParts[1]);

        ranges.addRange(rangeStart, rangeEnd);
      }

      System.out.println(ranges);

      while(true) {
        line = reader.readLine();
        if (line == null) break;

        long ingredient = Long.parseLong(line);
        if (ranges.containsNumber(ingredient)) {
          freshIngredients++;
        }
      }

    } catch (IOException e) {
      System.out.println("There was an error while trying to read from the day05 input");
      return;
    }
    
    System.out.println("Fresh ingredient count: " + freshIngredients);
  }
}
