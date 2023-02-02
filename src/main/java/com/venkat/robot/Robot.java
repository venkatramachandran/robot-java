package com.venkat.robot;

import java.util.Arrays;

public class Robot {
  private Position position;
  private Direction direction;
  private Table table;

  public Robot(Table table) {
    this.table = table;
  }

  public Position getPosition() {
    return this.position;
  }

  public void setPosition(Position position) {
    if (table.isValidPosition(position)) {
      this.position = position;
    }
  }

  public Table getTable() {
    return this.table;
  }

  public void setTable(Table table) {
    this.table = table;
  }

  public Direction getDirection() {
    return this.direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }
}
