package com.venkat.robot;

import org.junit.Test;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;

public class PlaceCommandTest {
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
        Command placeCommand = new PlaceCommand(mgr, new Position(1, 2), Direction.NORTH);
        placeCommand.execute();
        Robot robot = mgr.getActiveRobot();
        assertEquals(1, robot.getPosition().getX());
        assertEquals(2, robot.getPosition().getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }
}
