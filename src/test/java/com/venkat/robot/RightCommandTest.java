package com.venkat.robot;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RightCommandTest {
    private static RobotManager mgr;

    @BeforeClass
    public static void beforeClass() {
        Table table = new Table(5,5);
        Robot robot = new Robot();
        mgr = new RobotManager(table);
        mgr.addRobot(robot);
    }
    @Test
    public void testExecute() {
        new PlaceCommand(mgr, new Position(0, 0), Direction.NORTH).execute();
        LeftCommand command = new LeftCommand(mgr);
        command.execute();
        Robot robot = mgr.getActiveRobot();
        assertEquals(Direction.WEST, robot.getDirection());

        new PlaceCommand(mgr, new Position(0, 0), Direction.EAST).execute();
        command.execute();
        robot = mgr.getActiveRobot();
        assertEquals(Direction.NORTH, robot.getDirection());

        new PlaceCommand(mgr, new Position(0, 0), Direction.SOUTH).execute();
        command.execute();
        robot = mgr.getActiveRobot();
        assertEquals(Direction.EAST, robot.getDirection());

        new PlaceCommand(mgr, new Position(0, 0), Direction.WEST).execute();
        command.execute();
        robot = mgr.getActiveRobot();
        assertEquals(Direction.SOUTH, robot.getDirection());
    }
}
