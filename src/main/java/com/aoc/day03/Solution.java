package com.aoc.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Solution {
  public static void main(String[] args) {
    try(BufferedReader reader = Files.newBufferedReader(Paths.get("inputs/day03.txt"))) {

    } catch (IOException e) {
      System.out.println("There was an error while trying to read from the day03 input");
      return;
    }
  }
}
