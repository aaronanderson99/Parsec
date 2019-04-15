package com.example.parsec.model;

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

        //100 (amount of credits) < 500 (fuelSpace * 10), so fuel cannot be purchased
        //fuelSpace should have decreased by amount jumped, and not refueled to 100
        assertEquals(50.0, space);
    }

    @Test
    public void refuelWhenEnoughFuel() throws Exception {

        fueltank.jump(99); //makes fuelLevel = 1
        double space = fueltank.getFuelSpace(); //should be 99 before refueling, 0 after

        assertEquals(100, space);
    }

}
