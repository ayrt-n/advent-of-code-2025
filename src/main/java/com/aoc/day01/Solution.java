package com.aoc.day01;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
  public static void main(String[] args) {
    Lock lock = new Lock(50);
    int code = 0;

    try(BufferedReader reader = Files.newBufferedReader(Paths.get("inputs/day01.txt"))) {
      String line;

      while((line = reader.readLine()) != null) {
        String direction = line.substring(0, 1);
        int amount = Integer.parseInt(line.substring(1));

        lock.turn(direction, amount);

        if (lock.getPosition() == 0) {
          code += 1;
        }
      }
    } catch (Exception e) {
      System.out.println("There was an error while trying to read from the day01 input");
      return;
    }

    System.out.println("The code is: " + code);
  }
}