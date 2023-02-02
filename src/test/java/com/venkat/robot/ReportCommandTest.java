package com.venkat.robot;

import org.junit.Test;

import com.venkat.robot.Command;

import java.io.PrintWriter;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

public class ReportCommandTest {

    @Test
    public void testExecute() {
        Table table = new Table(5,5);
        Robot robot = new Robot(table);
        StringWriter writer = new StringWriter();
        PrintWriter out = new PrintWriter(writer);
        Command placeCommand = new PlaceCommand(new Position(0, 0), Direction.NORTH);
        placeCommand.execute(robot);
        Command moveCommand = new MoveCommand();
        moveCommand.execute(robot);
        moveCommand.execute(robot);
        Command rightCommand = new RightCommand();
        rightCommand.execute(robot);
        moveCommand.execute(robot);
        ReportCommand reportCommand = new ReportCommand();
        reportCommand.setOut(out);
        reportCommand.execute(robot);
        assertEquals("1,2,EAST\n", writer.toString());
    }
}
