package com.venkat.robot;

public class MoveCommand implements Command {
    @Override
    public void execute(Robot r) {
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
      r.setPosition(new Position(newX, newY));
    }
  }
  