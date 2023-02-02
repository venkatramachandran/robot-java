package com.venkat.robot;

public class LeftCommand implements Command {

    @Override
    public void execute(Robot r) {
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
  