package com.aoc.day05;

public class Range {
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

  public String toString() {
    return start + "-" + end;
  }
}
