package com.venkat.robot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaceCommandTest {
    @Test
    public void testExecute() {
        Table table = new Table(5, 5);
        Robot robot = new Robot(table);
        Command placeCommand = new PlaceCommand(new Position(1, 2), Direction.NORTH);
        placeCommand.execute(robot);
        assertEquals(1, robot.getPosition().getX());
        assertEquals(2, robot.getPosition().getY());
        assertEquals(Direction.NORTH, robot.getDirection());
    }
}
