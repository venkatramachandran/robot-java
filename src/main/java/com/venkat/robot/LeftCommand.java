package com.venkat.robot;

public class LeftCommand implements Command {

  private RobotManager mgr;

  public LeftCommand(RobotManager mgr) {
    this.mgr = mgr;
  }

    @Override
    public void execute() {
      Robot r = this.mgr.getActiveRobot();
      if (r.getDirection() == null) {
        return;
      }
      switch (r.getDirection()) {
        case NORTH:
          r.setDirection(Direction.WEST);
          break;
        case WEST:
          r.setDirection(Direction.SOUTH);
          break;
        case SOUTH:
          r.setDirection(Direction.EAST);
          break;
        case EAST:
          r.setDirection(Direction.NORTH);
          break;
      }
    }
  }
  