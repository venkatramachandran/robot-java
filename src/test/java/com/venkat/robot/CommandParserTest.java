package com.venkat.robot;

import org.junit.Test;
import org.junit.BeforeClass;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandParserTest {

    private static RobotManager mgr;
    private static CommandParser parser;

    @BeforeClass
    public static void beforeClass() {
        Table table = new Table(5,5);
        Robot robot = new Robot();
        mgr = new RobotManager(table);
        mgr.addRobot(robot);
        parser = new CommandParser(mgr);
    }

    @Test
    public void parsePlaceCommand() {
        Command command = parser.parse("PLACE 1,2,NORTH");

        assertTrue(command instanceof PlaceCommand);
        PlaceCommand placeCommand = (PlaceCommand) command;
        assertEquals(1, placeCommand.getPosition().getX());
        assertEquals(2, placeCommand.getPosition().getY());
        assertEquals(Direction.NORTH, placeCommand.getDirection());
    }

    @Test
    public void parseMoveCommand() {
        Command command = parser.parse("MOVE");

        assertTrue(command instanceof MoveCommand);
    }

    @Test
    public void parseLeftCommand() {
        Command command = parser.parse("LEFT");

        assertTrue(command instanceof LeftCommand);
    }

    @Test
    public void parseRightCommand() {
        Command command = parser.parse("RIGHT");

        assertTrue(command instanceof RightCommand);
    }

    @Test
    public void parseReportCommand() {
        Command command = parser.parse("REPORT");

        assertTrue(command instanceof ReportCommand);
    }
}
