package com.venkat.robot;

public class Table {
    private final int width;
    private final int height;
  
    public Table(int width, int height) {
      this.width = width;
      this.height = height;
    }
  
    public boolean isValidPosition(Position pos) {
      int x = pos.getX();
      int y = pos.getY();
      return x >= 0 && x < width && y >= 0 && y < height;
    }
  }
  