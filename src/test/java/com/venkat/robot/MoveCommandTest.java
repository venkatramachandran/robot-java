package com.venkat.robot;

import org.junit.Test;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;

public class MoveCommandTest {

    private static RobotManager mgr;

    @BeforeClass
    public static void beforeClass() {
        Table table = new Table(5,5);
        mgr = new RobotManager(table);
    }

    @Test
    public void testMove() {
        PlaceCommand placeCommand = new PlaceCommand(mgr, new Position(0, 0), Direction.NORTH);
        placeCommand.execute();

        MoveCommand moveCommand = new MoveCommand(mgr);
        moveCommand.execute();
        Robot robot = mgr.getActiveRobot();
        assertEquals(0, robot.getPosition().getX());
        assertEquals(1, robot.getPosition().getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void testMoveInvalid() {
        PlaceCommand placeCommand = new PlaceCommand(mgr, new Position(0, 0), Direction.SOUTH);
        placeCommand.execute();

        MoveCommand moveCommand = new MoveCommand(mgr);
        moveCommand.execute();
        Robot robot = mgr.getActiveRobot();

        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.SOUTH, robot.getDirection());
    }
}
