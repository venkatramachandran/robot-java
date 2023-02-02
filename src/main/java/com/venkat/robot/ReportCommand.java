package com.venkat.robot;

import java.io.PrintWriter;

public class ReportCommand implements Command {
    private PrintWriter out;
    public ReportCommand() {
      this.out = new PrintWriter(System.out, true);
    }
    public void setOut(PrintWriter out) {
      this.out = out;
    }
    @Override
    public void execute(Robot r) {
      if (r.getDirection() == null) {
        return;
      }
      this.out.println(r.getPosition().getX() + "," + r.getPosition().getY() + "," + r.getDirection().toString());
    }
  }
  