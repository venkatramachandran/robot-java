package com.venkat.robot;

import java.util.Scanner;
import java.util.Optional; 

public class CommandParser {
    private RobotManager mgr;
    public CommandParser(RobotManager mgr) {
      this.mgr = mgr;
    }
  
    public Command parse(String cmd) {
  
      String[] parts = cmd.split(" ");
      String commandName = parts[0];
  
      switch (commandName) {
        case "PLACE":
          int x = Integer.parseInt(parts[1].split(",")[0]);
          int y = Integer.parseInt(parts[1].split(",")[1]);
          Direction direction = Direction.valueOf(parts[1].split(",")[2]);
          return new PlaceCommand(mgr, new Position(x, y), direction);
        case "ROBOT":
          int index = Integer.parseInt(parts[1].split(",")[0]);
          return new RobotCommand(mgr, index);
        case "MOVE":
          return new MoveCommand(mgr);
        case "LEFT":
          return new LeftCommand(mgr);
        case "RIGHT":
          return new RightCommand(mgr);
        case "REPORT":
          return new ReportCommand(mgr);
        default:
          return null;
      }
    }
  }
  