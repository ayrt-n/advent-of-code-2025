package com.aoc.day04;

import java.util.List;

public class PaperRolls {
  private List<String> grid;

  public PaperRolls(List<String> grid) {
    this.grid = grid;
  }

  public int accessible() {
    int count = 0;

    for (int r = 0; r < rows(); r++) {
      for (int c = 0; c < columns(r); c++) {
        if (containsRoll(r, c) && isAccessible(r, c)) {
          count++;
        }
      }
    }

    return count;
  }

  public boolean isAccessible(int row, int col) {
    int numAdjacentRolls = 0;
    int[][] adjacentSpots = { {-1, 0}, {1, 0}, {-1, 1}, {1, 1}, {-1, -1}, {1, -1}, {0, -1}, {0, 1} };

    for (int[] adjacentSpot : adjacentSpots) {
      int r = row + adjacentSpot[1];
      int c = col + adjacentSpot[0];

      if (containsRoll(r, c)) {
        numAdjacentRolls++;
      }
    }

    return numAdjacentRolls < 4;
  }

  private boolean outOfBounds(int row, int col) {
    if (row < 0 || col < 0 || row >= rows() || col >= columns(row)) {
      return true;
    }

    return false;
  }

  private boolean containsRoll(int row, int col) {
    if (outOfBounds(row, col)) return false;

    return grid.get(row).charAt(col) == '@';
  }

  private int rows() {
    return grid.size();
  }

  private int columns(int row) {
    return grid.get(row).length();
  }

  public static void main(String[] args) {
    // For testing
  }
}
