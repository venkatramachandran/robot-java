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
        int tableX = -1;
        int tableY = -1;
        try {
            tableX = Integer.parseInt(System.getProperty("BOARD_X_SIZE"));
        } catch (NumberFormatException nfe) {
            tableX = BOARD_X_SIZE;
        }
        try {
            tableY = Integer.parseInt(System.getProperty("BOARD_Y_SIZE"));
        } catch (NumberFormatException nfe) {
            tableY = BOARD_Y_SIZE;
        }
        Table table = new Table(tableX, tableY);
        RobotManager mgr = new RobotManager(table);

        CommandParser cmdParser = new CommandParser(mgr);
        String line = "";
        try (Scanner scanner = new Scanner(new File(file))){
            while (scanner.hasNextLine()) {
                cmdParser.parse(scanner.nextLine()).execute();
            }
        } catch(FileNotFoundException fnfe) {
            System.err.println(fnfe.getMessage());
        }
    }

    private static void usage() {
        System.out.println("Usage: java com.venkat.robot.Main <filename>");
    }
}