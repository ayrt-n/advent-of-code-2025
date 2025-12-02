package com.aoc.day02;

public class Id {
  private String id;

  public Id(String id) {
    this.id = id;
  }

  public boolean isValidSimple() {
    if (length() % 2 != 0) return true;

    int subStrLen = length() / 2;
    return !hasRepeatingSubstring(subStrLen);
  }

  public boolean isValidComplex() {
    for (int subStrLen = 1; subStrLen <= length() / 2; subStrLen++) {
      if (length() % subStrLen != 0) continue;
      if (hasRepeatingSubstring(subStrLen)) return false;
    }

    return true;
  }

  public int length() {
    return id.length();
  }

  private boolean hasRepeatingSubstring(int subStrLen) {
    if (length() % subStrLen != 0) return false;

    int i = 0;
    int numSubStrings = length() / subStrLen;

    while(i < subStrLen) {
      char initialChar = id.charAt(i);

      for (int j = 1; j < numSubStrings; j++) {
        int subStrIndex = (j * subStrLen) + i;
        char subStrChar = id.charAt(subStrIndex);

        if (subStrChar != initialChar) return false;
      }

      i++;
    }

    return true;
  }
}