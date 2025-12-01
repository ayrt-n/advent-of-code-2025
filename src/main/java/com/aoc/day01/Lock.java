package com.aoc.day01;

public class Lock {
  private int position;

  public Lock(int startPosition) {
    this.position = startPosition;
  }

  public int getPosition() {
    return this.position;
  }

  public void turn(String direction, int amount) {
    amount = direction.equals("L") ? amount * -1 : amount;
    position = (position + amount) % 100;
  }
}
