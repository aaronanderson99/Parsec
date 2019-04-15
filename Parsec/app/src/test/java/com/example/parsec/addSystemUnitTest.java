package com.example.parsec;

import com.example.parsec.model.Characteristic;
import com.example.parsec.model.Coordinate;
import com.example.parsec.model.System;
import com.example.parsec.model.TechLevel;
import com.example.parsec.model.Universe;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class addSystemUnitTest {
    private Universe universe;

    @Before
    public void setUp(){
        universe = new Universe();
        universe.setStarterSystem();
    }

    @Test
    public void addSystemEmpty() {
        System testSystem = new System(4, "TestSystem", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(5,5));
        int systemCount = universe.getSystemsCount();
        universe.addSystem(testSystem);
        //should be true after adding a system
        assertTrue(testSystem.getId()!= universe.getStarterSystem().getId());
        assertEquals(systemCount + 1, universe.getSystemsCount());

    }

    @Test
    public void addSystemFull() {
        System testSystem = new System(5, "TestSystem", TechLevel.PRE_AGRICULTURE,
                Characteristic.NOSPECIALRESOURCES, new Coordinate(5,5));
        int systemCount = universe.getSystemsCount();
        universe.addSystem(testSystem);
        //shouldn't happen
        assertFalse(testSystem.getId()== universe.getStarterSystem().getId());
        assertEquals(systemCount, universe.getSystemsCount());

    }
}