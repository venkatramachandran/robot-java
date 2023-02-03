package com.venkat.robot;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.BeforeClass;

public class RobotTest {
    private static RobotManager mgr;

    @BeforeClass
    public static void beforeClass() {
        Table table = new Table(5,5);
        Robot robot = new Robot();
        mgr = new RobotManager(table);
        mgr.addRobot(robot);
    }
    @Test
    public void testPlace() {
        new PlaceCommand(mgr, new Position(0, 0), Direction.NORTH).execute();
        Robot robot = mgr.getActiveRobot();
        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());      
        assertEquals(Direction.NORTH, robot.getDirection());

        new PlaceCommand(mgr, new Position(4, 4), Direction.SOUTH).execute();
        robot = mgr.getActiveRobot();
        assertEquals(4, robot.getPosition().getX());
        assertEquals(4, robot.getPosition().getY());
        assertEquals(Direction.SOUTH, robot.getDirection());

        new PlaceCommand(mgr, new Position(3, 2), Direction.EAST).execute();
        robot = mgr.getActiveRobot();
        assertEquals(3, robot.getPosition().getX());
        assertEquals(2, robot.getPosition().getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    public void testMove() {
        new PlaceCommand(mgr, new Position(0, 0), Direction.NORTH).execute();
        new MoveCommand(mgr).execute();
        Robot robot = mgr.getActiveRobot();
        assertEquals(0, robot.getPosition().getX());
        assertEquals(1, robot.getPosition().getY());
        assertEquals(Direction.NORTH, robot.getDirection());

        new PlaceCommand(mgr, new Position(4, 4), Direction.SOUTH).execute();
        new MoveCommand(mgr).execute();
        robot = mgr.getActiveRobot();
        assertEquals(4, robot.getPosition().getX());
        assertEquals(3, robot.getPosition().getY());
        assertEquals(Direction.SOUTH, robot.getDirection());

        new PlaceCommand(mgr, new Position(0, 4), Direction.WEST).execute();
        new MoveCommand(mgr).execute();
        robot = mgr.getActiveRobot();
        assertEquals(0, robot.getPosition().getX());
        assertEquals(4, robot.getPosition().getY());
        assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    public void testLeft() {
        new PlaceCommand(mgr, new Position(0, 0), Direction.NORTH).execute();
        new LeftCommand(mgr).execute();
        Robot robot = mgr.getActiveRobot();
        assertEquals(Direction.WEST, robot.getDirection());

        new LeftCommand(mgr).execute();
        assertEquals(Direction.SOUTH, robot.getDirection());

        new LeftCommand(mgr).execute();
        assertEquals(Direction.EAST, robot.getDirection());

        new LeftCommand(mgr).execute();
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void testRight() {

        new PlaceCommand(mgr, new Position(0, 0), Direction.NORTH).execute();
        new RightCommand(mgr).execute();
        Robot robot = mgr.getActiveRobot();
        assertEquals(Direction.EAST, robot.getDirection());

        new RightCommand(mgr).execute();
        assertEquals(Direction.SOUTH, robot.getDirection());

        new RightCommand(mgr).execute();
        assertEquals(Direction.WEST, robot.getDirection());

        new RightCommand(mgr).execute();
        assertEquals(Direction.NORTH, robot.getDirection());
    }
}
