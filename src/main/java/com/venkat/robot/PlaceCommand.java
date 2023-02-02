package com.venkat.robot;

public class PlaceCommand implements Command {
    private Position position;
    private Direction direction;

    public Position getPosition() {
      return this.position;
    }

    public void setPosition(Position pos) {
      this.position = pos;
    }

    public Direction getDirection() {
      return this.direction;
    }

    public void setDirection(Direction direction) {
      this.direction = direction;
    }


    public PlaceCommand(Position pos, Direction direction) {
      this.position = pos;
      this.direction = direction;
    }
  
    @Override
    public void execute(Robot r) {
      r.setPosition(this.position);
      r.setDirection(this.direction);
  }
}
  