package com.venkat.robot;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    private static final int BOARD_X_SIZE = 5;
    private static final int BOARD_Y_SIZE = 5;

    public static void main(String[] args) {
        if (args.length != 1) {
            usage();
            System.exit(-1);
        }
        String file = args[0];
        Table table = new Table(BOARD_X_SIZE, BOARD_Y_SIZE);
        Robot robot = new Robot(table);
        CommandParser cmdParser = new CommandParser();
        String line = "";
        try (Scanner scanner = new Scanner(new File(file))){
            while (scanner.hasNextLine()) {
                cmdParser.parse(scanner.nextLine()).execute(robot);
            }
        } catch(FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        }
    }

    private static void usage() {
        System.out.println("Usage: java com.venkat.robot.Main <filename>");
    }
}