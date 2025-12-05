package com.aoc.day05;

import java.util.ArrayList;
import java.util.List;

public class Ranges {
  private List<Range> ranges;

  public Ranges() {
    this.ranges = new ArrayList<>();
  }

  public void addRange(long start, long end) {
    Range newRange = new Range(start, end);

    for (int i = 0; i < ranges.size(); i++) {
      Range existingRange = ranges.get(i);

      if (newRange.getEnd() < existingRange.getStart()) {
        ranges.add(0, newRange);
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

  public String toString() {
    return ranges.toString();
  }
}
