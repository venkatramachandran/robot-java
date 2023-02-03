package com.venkat.robot;

import java.io.PrintWriter;

public class ReportCommand implements Command {
    private PrintWriter out;
    private RobotManager mgr;
    public ReportCommand(RobotManager mgr) {
      this.mgr = mgr;
      this.out = new PrintWriter(System.out, true);
    }
    public void setOut(PrintWriter out) {
      this.out = out;
    }
    @Override
    public void execute() {
      Robot r = this.mgr.getActiveRobot();
      if (r.getDirection() == null) {
        return;
      }
      this.out.printf("Total: %d, Active Index: %d, X: %d, Y: %d, Direction: %s\n", 
        this.mgr.getTotalRobots(),
        this.mgr.getActiveRobotIndex(),
        r.getPosition().getX(),
        r.getPosition().getY(),
        r.getDirection().toString());
    }
  }
  