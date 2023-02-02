package com.venkat.robot;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class RobotTest {
    @Test
    public void testPlace() {
        Table table = new Table(5, 5);
        Robot robot = new Robot(table);

        new PlaceCommand(new Position(0, 0), Direction.NORTH).execute(robot);
        assertEquals(0, robot.getPosition().getX());
        assertEquals(0, robot.getPosition().getY());
        assertEquals(Direction.NORTH, robot.getDirection());

        new PlaceCommand(new Position(4, 4), Direction.SOUTH).execute(robot);
        assertEquals(4, robot.getPosition().getX());
        assertEquals(4, robot.getPosition().getY());
        assertEquals(Direction.SOUTH, robot.getDirection());

        new PlaceCommand(new Position(5, 5), Direction.EAST).execute(robot);
        assertEquals(4, robot.getPosition().getX());
        assertEquals(4, robot.getPosition().getY());
        assertEquals(Direction.EAST, robot.getDirection());
    }

    @Test
    public void testMove() {
        Table table = new Table(5, 5);
        Robot robot = new Robot(table);

        new PlaceCommand(new Position(0, 0), Direction.NORTH).execute(robot);
        new MoveCommand().execute(robot);
        assertEquals(0, robot.getPosition().getX());
        assertEquals(1, robot.getPosition().getY());
        assertEquals(Direction.NORTH, robot.getDirection());

        new PlaceCommand(new Position(4, 4), Direction.SOUTH).execute(robot);
        new MoveCommand().execute(robot);
        assertEquals(4, robot.getPosition().getX());
        assertEquals(3, robot.getPosition().getY());
        assertEquals(Direction.SOUTH, robot.getDirection());

        new PlaceCommand(new Position(0, 4), Direction.WEST).execute(robot);
        new MoveCommand().execute(robot);
        assertEquals(0, robot.getPosition().getX());
        assertEquals(4, robot.getPosition().getY());
        assertEquals(Direction.WEST, robot.getDirection());
    }

    @Test
    public void testLeft() {
        Table table = new Table(5, 5);
        Robot robot = new Robot(table);

        new PlaceCommand(new Position(0, 0), Direction.NORTH).execute(robot);
        new LeftCommand().execute(robot);
        assertEquals(Direction.WEST, robot.getDirection());

        new LeftCommand().execute(robot);
        assertEquals(Direction.SOUTH, robot.getDirection());

        new LeftCommand().execute(robot);
        assertEquals(Direction.EAST, robot.getDirection());

        new LeftCommand().execute(robot);
        assertEquals(Direction.NORTH, robot.getDirection());
    }

    @Test
    public void testRight() {
        Table table = new Table(5, 5);
        Robot robot = new Robot(table);

        new PlaceCommand(new Position(0, 0), Direction.NORTH).execute(robot);
        new RightCommand().execute(robot);
        assertEquals(Direction.EAST, robot.getDirection());

        new RightCommand().execute(robot);
        assertEquals(Direction.SOUTH, robot.getDirection());

        new RightCommand().execute(robot);
        assertEquals(Direction.WEST, robot.getDirection());

        new RightCommand().execute(robot);
        assertEquals(Direction.NORTH, robot.getDirection());
    }
}
