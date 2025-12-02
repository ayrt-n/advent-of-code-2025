package com.aoc.day02;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
  public static void main(String[] args) {
    long res = 0;

    try(BufferedReader reader = Files.newBufferedReader(Paths.get("inputs/day02.txt"))) {
      String ids = reader.readLine();
      String[] ranges = ids.split(",");

      for (String range : ranges) {
        String[] rangeParts = range.split("-");
        long start = Long.parseLong(rangeParts[0]);
        long end = Long.parseLong(rangeParts[1]);

        for (long i = start; i <= end; i++) {
          Id id = new Id(String.valueOf(i));
          if (id.isValidSimple()) continue;

          res += i;
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.out.println("There was an error while trying to read from the day01 input");
      return;
    }

    System.out.println((int) Math.ceil(7 / 2.0));

    System.out.println("The number of invalid ids: " + res);
  }
}