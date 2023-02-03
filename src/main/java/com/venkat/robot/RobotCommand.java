package com.venkat.robot;


public class RobotCommand implements Command {
    private RobotManager mgr;
    private int index;

    public RobotCommand(RobotManager mgr, int index) {
        this.mgr = mgr;
        this.index = index;
    }
    
    @Override
    public void execute() {
        this.mgr.setActiveRobot(this.index);
    }
  }