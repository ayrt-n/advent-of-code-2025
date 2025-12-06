package com.aoc.day05;

import java.util.ArrayList;
import java.util.List;

public class Ranges {
  private List<Range> ranges;

  public Ranges() {
    this.ranges = new ArrayList<>();
  }

  public boolean containsNumber(Long num) {
    int left = 0;
    int right = ranges.size() - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      Range midRange = ranges.get(mid);
      int compValue = midRange.compareTo(num);

      if (compValue == 0) {
        return true;
      }

      if (compValue < 0) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }

    return false;
  }

  public void addRange(long start, long end) {
    Range newRange = new Range(start, end);

    for (int i = 0; i < ranges.size(); i++) {
      Range existingRange = ranges.get(i);

      if (newRange.getEnd() < existingRange.getStart()) {
        ranges.add(i, newRange);
        return;
      }

      if (existingRange.contains(newRange)) {
        return;
      }

      if (existingRange.overlaps(newRange)) {
        existingRange.setStart(Math.min(existingRange.getStart(), newRange.getStart()));
        existingRange.setEnd(Math.max(existingRange.getEnd(), newRange.getEnd()));

        for (int j = i + 1; j < ranges.size(); j++) {
          Range compRange = ranges.get(j);
          if (compRange.getStart() > existingRange.getEnd()) break;

          existingRange.setEnd(Math.max(existingRange.getEnd(), compRange.getEnd()));
          ranges.remove(j);
        }

        return;
      }
    }

    ranges.add(newRange);
  }

  public long totalInRanges() {
    long sum = 0;

    for (Range range : ranges) {
      sum += range.valueInRange();
    }

    return sum;
  }

  public String toString() {
    return ranges.toString();
  }
}
