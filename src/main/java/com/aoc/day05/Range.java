package com.aoc.day05;

public class Range implements Comparable<Long> {
  private long start;
  private long end;

  public Range(long start, long end) {
    this.start = start;
    this.end = end;
  }

  public long getStart() {
    return start;
  }

  public long getEnd() {
    return end;
  }

  public void setStart(long num) {
    this.start = num;
  }

  public void setEnd(long num) {
    this.end = num;
  }

  public boolean overlaps(Range range) {
    return contains(range) || (range.start <= start && range.end >= start) || (range.start <= end && range.end >= end);
  }

  public boolean contains(Range range) {
    return (range.start >= start && range.end <= end);
  }

  public int compareTo(Long num) {
    if (start <= num && end >= num) {
      return 0;
    }

    return (num < start) ? -1 : 1;
  }

  public long valueInRange() {
    return (end - start + 1);
  }

  public String toString() {
    return start + "-" + end;
  }
}
