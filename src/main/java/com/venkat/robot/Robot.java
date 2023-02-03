package com.venkat.robot;

import java.util.Arrays;

public class Robot {
  private Position position;
  private Direction direction;

  public Robot(Position position, Direction direction) {
    this.position = position;
    this.direction = direction;
  }

  public Robot() {
  }

  public Position getPosition() {
    return this.position;
  }

  public void setPosition(Position position) {
    this.position = position;
  }

  public Direction getDirection() {
    return this.direction;
  }

  public void setDirection(Direction direction) {
    this.direction = direction;
  }
}
