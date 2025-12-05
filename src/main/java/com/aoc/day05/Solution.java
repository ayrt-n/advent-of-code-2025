package com.aoc.day05;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class Solution {
  public static void main(String[] args) {
    Ranges ranges = new Ranges();

    try (BufferedReader reader = Files.newBufferedReader(Paths.get("inputs/day05-test.txt"))) {
      String line;
      
      while (true) {
        line = reader.readLine();
        if (line == null || line.isEmpty()) break;

        String[] rangeParts = line.split("-");
        long rangeStart = Long.parseLong(rangeParts[0]);
        long rangeEnd = Long.parseLong(rangeParts[1]);

        ranges.addRange(rangeStart, rangeEnd);
      }

      while(true) {
        line = reader.readLine();
        if (line == null) break;
      }

    } catch (IOException e) {
      System.out.println("There was an error while trying to read from the day05 input");
      return;
    }
    
    System.out.println(ranges);
  }
}
