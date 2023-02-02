package com.venkat.robot;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CommandParserTest {

    @Test
    public void parsePlaceCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("PLACE 1,2,NORTH");

        assertTrue(command instanceof PlaceCommand);
        PlaceCommand placeCommand = (PlaceCommand) command;
        assertEquals(1, placeCommand.getPosition().getX());
        assertEquals(2, placeCommand.getPosition().getY());
        assertEquals(Direction.NORTH, placeCommand.getDirection());
    }

    @Test
    public void parseMoveCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("MOVE");

        assertTrue(command instanceof MoveCommand);
    }

    @Test
    public void parseLeftCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("LEFT");

        assertTrue(command instanceof LeftCommand);
    }

    @Test
    public void parseRightCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("RIGHT");

        assertTrue(command instanceof RightCommand);
    }

    @Test
    public void parseReportCommand() {
        CommandParser parser = new CommandParser();
        Command command = parser.parse("REPORT");

        assertTrue(command instanceof ReportCommand);
    }
}
