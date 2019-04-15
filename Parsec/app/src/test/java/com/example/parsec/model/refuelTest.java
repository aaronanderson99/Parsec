package com.example.parsec.model;

import org.junit.Test;
import com.example.parsec.model.Characteristic;
import com.example.parsec.model.Coordinate;
import com.example.parsec.model.Player;
import com.example.parsec.model.Resource;
import com.example.parsec.model.Ship;
import com.example.parsec.model.ShipType;
import com.example.parsec.model.System;
import com.example.parsec.model.TechLevel;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class refuelTest {
    private Player player;
    private Player brokePlayer;
    @Before
    public void setUp() {
        player = new Player("TestPlayer", new Ship(ShipType.Dragonfly), 4, 4, 4, 4, 10000);
        player.getShip().setCurrentSystem(new System(0, "system", TechLevel.HI_TECH, Characteristic.NOSPECIALRESOURCES, new Coordinate(0, 0)));
        brokePlayer = new Player("TestPlayer", new Ship(ShipType.Dragonfly), 4, 4, 4, 4, 0);
        brokePlayer.getShip().setCurrentSystem(new System(0, "system", TechLevel.HI_TECH, Characteristic.NOSPECIALRESOURCES, new Coordinate(0, 0)));

    }
    @Test
    // This test makes sure that fuel and credits are updated properly from successful refuels.
    public void testRefuelEmptyTank() {
        //Empty Tank
        double credits = player.getCredits().getCredits();
        FuelTank fuelTank = player.getShip().getFuelTank();
        double fuelLevel = fuelTank.getFuel();
        fuelTank.jump(fuelTank.getMaxFuel());
        player.refuel();
        // The credits the player has should have decreased by the cost of fuel.
        assertEquals(player.getCredits().getCredits(), credits - (fuelTank.getFuelSpace() * 10));

        // The fuelTank should be full
        assertEquals(fuelTank.getMaxFuel(), fuelLevel);
    }
    @Test
    // This test makes sure that fuel is still full and credits are unchanged.
    public void testRefuelFullTank() {
        //Empty Tank
        double credits = player.getCredits().getCredits();
        FuelTank fuelTank = player.getShip().getFuelTank();
        double fuelLevel = fuelTank.getFuel();
        player.refuel();
        // The credits the player has should be unchanged.
        assertEquals(player.getCredits().getCredits(), credits);

        // The fuelTank should be full
        assertEquals(fuelTank.getMaxFuel(), fuelLevel);
    }

    @Test
    /* This method return false since they are no credits and fuel & credits are unchanged
    */
    public void testRefuelNoCredits() {
        //Empty Tank
        double credits = brokePlayer.getCredits().getCredits();
        FuelTank fuelTank = brokePlayer.getShip().getFuelTank();
        double fuelLevel = fuelTank.getFuel();
        player.refuel();
        // The credits the player has should be unchanged.
        assertEquals(player.getCredits().getCredits(), credits);

        // The fuelTank should be unchanged
        assertEquals(fuelTank.getFuel(), fuelLevel);
    }
}