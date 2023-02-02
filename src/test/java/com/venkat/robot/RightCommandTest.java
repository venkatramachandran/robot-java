package com.venkat.robot;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RightCommandTest {
    @Test
    public void testExecute() {
        Robot robot = new Robot(new Table(5,5));
        new PlaceCommand(new Position(0, 0), Direction.NORTH).execute(robot);
        LeftCommand command = new LeftCommand();
        command.execute(robot);
        assertEquals(Direction.WEST, robot.getDirection());

        new PlaceCommand(new Position(0, 0), Direction.EAST).execute(robot);
        command.execute(robot);
        assertEquals(Direction.NORTH, robot.getDirection());

        new PlaceCommand(new Position(0, 0), Direction.SOUTH).execute(robot);
        command.execute(robot);
        assertEquals(Direction.EAST, robot.getDirection());

        new PlaceCommand(new Position(0, 0), Direction.WEST).execute(robot);
        command.execute(robot);
        assertEquals(Direction.SOUTH, robot.getDirection());
    }
}
