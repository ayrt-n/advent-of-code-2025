package com.aoc.day03;

import java.util.Arrays;

public class Bank {
  private String batteries;

  public Bank(String batteries) {
    this.batteries = batteries;
  }

  public int maximumJoltage() {
    char[] res = { '0', '0' };

    for(int i = 0; i < batteries.length(); i++)  {
      char batteryValue = batteries.charAt(i);

      if (batteryValue > res[0] && i < batteries.length() - 1) {
        res[0] = batteryValue;
        res[1] = '0';
      } else if (batteryValue > res[1]) {
        res[1] = batteryValue;
      }
    }

    return Integer.parseInt(new String(res));
  }

  public long maximumJoltage(int numBatteries) {
    char[] res = new char[numBatteries];
    Arrays.fill(res, '0');

    for (int i = 0; i < batteries.length(); i++) {
      char batteryValue = batteries.charAt(i);

      for (int j = 0; j < numBatteries; j++) {
        if (batteryValue > res[j] && i < batteries.length() - (numBatteries - j - 1)) {
          res[j] = batteryValue;

          for (int k = j + 1; k < numBatteries; k++) {
            res[k] = '0';
          }

          break;
        }
      }
    }

    return Long.parseLong(new String(res));
  }
}
