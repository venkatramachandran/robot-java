package com.venkat.robot;

import org.junit.Test;
import org.junit.BeforeClass;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class ReportCommandTest {
    private static RobotManager mgr;

    @BeforeClass
    public static void beforeClass() {
        Table table = new Table(5,5);
        mgr = new RobotManager(table);
    }

    @Test
    public void testExecute() {
        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        Command placeCommand = new PlaceCommand(mgr, new Position(0, 0), Direction.NORTH);
        placeCommand.execute();
        Command moveCommand = new MoveCommand(mgr);
        moveCommand.execute();
        moveCommand.execute();
        Command rightCommand = new RightCommand(mgr);
        rightCommand.execute();
        moveCommand.execute();
        ReportCommand reportCommand = new ReportCommand(mgr);
        reportCommand.setOut(out);
        reportCommand.execute();
        Robot robot = mgr.getActiveRobot();
        assertEquals("Total: 1, Active Index: 1, X: 1, Y: 2, Direction: EAST\n", writer.toString());
    }
}
