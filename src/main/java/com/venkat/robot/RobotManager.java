package com.venkat.robot;

import java.util.List;
import java.util.ArrayList;

public class RobotManager {
    private Table table;
    private List<Robot> robots;
    private int activeIndex = -1;

    public RobotManager(Table table) {
        this.table = table;
        this.robots = new ArrayList<Robot>();
    }
    public void addRobot(Robot r) {
        this.robots.add(r);
        this.activeIndex = this.robots.size();
    }

    public Robot getActiveRobot() {
        return this.robots.get(this.activeIndex - 1);
    }

    public void setActiveRobot(int index) {
        this.activeIndex = index;
    }

    public int getActiveRobotIndex() {
        return this.activeIndex;
    }

    public int getTotalRobots() {
        return this.robots.size();
    }

    public Table getTable() {
        return this.table;
    }
}