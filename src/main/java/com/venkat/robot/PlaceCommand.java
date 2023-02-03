package com.venkat.robot;

public class PlaceCommand implements Command {
    private Position position;
    private Direction direction;
    private RobotManager mgr;

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


    public PlaceCommand(RobotManager mgr, Position pos, Direction direction) {
      this.mgr = mgr;
      this.position = pos;
      this.direction = direction;
    }
  
    @Override
    public void execute() {
      if (this.mgr.getTable().isValidPosition(this.position)) {
        this.mgr.addRobot(new Robot(this.position, this.direction));
      }
  }
}
  