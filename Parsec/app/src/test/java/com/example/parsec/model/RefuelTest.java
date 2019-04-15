package com.example.parsec.model;

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

public class RefuelTest {
    private Player player;
    private Player player2;
    private FuelTank fueltank;
    //private FuelTank fueltank2;

    @Before
    public void setUp(){
        player = new Player("Player", new Ship(ShipType.Gnat), 4, 4, 4, 4, 100);
        player2 = new Player("Player", new Ship(ShipType.Gnat), 4, 4, 4, 4, 1000);
        fueltank = new FuelTank(100); //max fuel and fuel level are 100, fuel space is 0
        //fueltank2 = new FuelTank(100);
    }

    @Test
    public void refuelWhenNotEnoughFuel() throws Exception {

        fueltank.jump(50); //fuel level is now 50
        double space = fueltank.getFuelSpace(); //its 50

        boolean output1;

        //100<500, so fuel cannot be purchased
        output1 = player.refuel();

        assertFalse(output1);

        //fuelSpace should have decreased by amount jumped
        assertEquals(space, 50);
    }

    @Test
    public void refuelWhenEnoughFuel() throws Exception {

        fueltank.jump(99);
        double space = fueltank.getFuelSpace(); //should be 1

        boolean output2 = player2.refuel();

        assertTrue(output2);
        assertEquals(space, 1);
    }

}
