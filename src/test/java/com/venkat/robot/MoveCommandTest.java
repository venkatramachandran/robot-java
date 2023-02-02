package com.venkat.robot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveCommandTest {

    @Test
    public void testMove() {
        Table table = new Table(5, 5);
        Robot robot = new Robot(table);
        PlaceCommand placeCommand = new PlaceCommand(new Position(0, 0), Direction.NORTH);
        placeCommand.execute(robot);

        MoveCommand moveCommand = new MoveCommand();
        moveCommand.execute(robot);

        assertEquals(0, robot.getPosition().getX());
        assertEquals(1, robot.getPosition().getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void testMoveInvalid() {
        Table table = new Table(5, 5);
        Robot robot = new Robot(table);
        PlaceCommand placeCommand = new PlaceCommand(new Position(0, 0), Direction.SOUTH);
        placeCommand.execute(robot);

        MoveCommand moveCommand = new MoveCommand();
        moveCommand.execute(robot);

        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.SOUTH, robot.getDirection());
    }
}
