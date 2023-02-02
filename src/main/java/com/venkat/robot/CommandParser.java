package com.venkat.robot;

import java.util.Scanner;
import java.util.Optional; 

public class CommandParser {
    public CommandParser() {
    }
  
    public Command parse(String cmd) {
  
      String[] parts = cmd.split(" ");
      String commandName = parts[0];
  
      switch (commandName) {
        case "PLACE":
          int x = Integer.parseInt(parts[1].split(",")[0]);
          int y = Integer.parseInt(parts[1].split(",")[1]);
          Direction direction = Direction.valueOf(parts[1].split(",")[2]);
          return new PlaceCommand(new Position(x, y), direction);
        case "MOVE":
          return new MoveCommand();
        case "LEFT":
          return new LeftCommand();
        case "RIGHT":
          return new RightCommand();
        case "REPORT":
          return new ReportCommand();
        default:
          return null;
      }
    }
  }
  