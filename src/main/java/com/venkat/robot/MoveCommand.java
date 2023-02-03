package com.venkat.robot;

public class MoveCommand implements Command {
  private RobotManager mgr;

  public MoveCommand(RobotManager mgr) {
    this.mgr = mgr;
  }
    @Override
    public void execute() {
      Robot r = this.mgr.getActiveRobot();
      if (r.getDirection() == null) {
        return;
      }
      int newX = r.getPosition().getX();
      int newY = r.getPosition().getY();
      switch (r.getDirection()) {
        case NORTH:
          newY++;
          break;
        case EAST:
          newX++;
          break;
        case SOUTH:
          newY--;
          break;
        case WEST:
          newX--;
          break;
      }
      Position pos = new Position(newX, newY);
      if (mgr.getTable().isValidPosition(pos)) {
        r.setPosition(pos);
      }
    }
  }
  