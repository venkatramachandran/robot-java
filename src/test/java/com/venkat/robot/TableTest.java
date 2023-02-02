package com.venkat.robot;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TableTest {
    @Test
    public void testIsValidPosition() {
        Table table = new Table(5, 5);
        assertTrue(table.isValidPosition(new Position(0, 0)));
        assertTrue(table.isValidPosition(new Position(4, 4)));
        assertFalse(table.isValidPosition(new Position(-1, 0)));
        assertFalse(table.isValidPosition(new Position(0, -1)));
        assertFalse(table.isValidPosition(new Position(5, 0)));
        assertFalse(table.isValidPosition(new Position(0, 5)));
    }
}
