package com.example.parsec;

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

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class SellUnitTest {

    private Player player;

    @Before
    public void setUp() {

        // Ignore feature envy here. I'm bypassing the usual conditions for setting player elements to create a hypothetical scenario.
        // System should have a high enough tech level to buy any resource, and the price of each resource should be set to its base price.
        player = new Player("Player", new Ship(ShipType.Dragonfly), 4, 4, 4, 4, 10000);
        player.getShip().setCurrentSystem(new System(0, "system", TechLevel.HI_TECH, Characteristic.NOSPECIALRESOURCES, new Coordinate(0, 0)));
        player.generateMarket();

        // Sets the price of each resource to the base price of that resource.
        for(Resource r : Resource.values()) {
            player.getShip().getCurrentSystem().getMarket().setMarketPrice(r, r.getBasePrice());
        }

        // Initializes player cargo to contain 10 of each item.
        for(Resource r : Resource.values()) {
            player.getShip().getCurrentSystem().getMarket().setMarketPrice(r, r.getBasePrice());
            player.getShip().getCargo().buy(r, 10);
        }
    }


    @Test
    // This test makes sure that cargo and credits are updated properly from successful transactions.
    public void testSellAllGoods() {
        double credits = player.getCredits().getCredits();

        for (Resource r : Resource.values()) {
            assertTrue(player.sell(r, 10));
            credits += r.getBasePrice() * 10;
        }

        // The credits the player has should have increased by the market price of all the resources they sold.
        assertEquals(credits, player.getCredits().getCredits());

        // The cargo should now be empty.
        assertEquals(0, player.getShip().getCargo().getCargoFilled());
    }

    @Test
    /* This method makes sure sell() returns false when trying to sell more resources than you have, and that
     * cargo and credits are not affected by failed transactions.
     */
    public void testSellMoreResourcesThanYouHave() {

        double creditsBefore = player.getCredits().getCredits();
        int incargoBefore = player.getShip().getCargo().getCargoStock(Resource.Water);

        // Should not be able to do this!
        assertFalse(player.sell(Resource.Water, 11));

        // Player credits and cargo should not have changed from failed transaction
        assertEquals(creditsBefore, player.getCredits().getCredits());
        assertEquals(incargoBefore, player.getShip().getCargo().getCargoStock(Resource.Water));
    }

    @Test
    /* This method makes sure sell() returns false when trying to sell resources above the current planet's
     * tech level, and that cargo and credits are not affected by failed transactions.
     */
    public void testSellResourceAbovePlanetTechLevel() {
        // Setting the current system to one with a low tech level.
        player.getShip().setCurrentSystem(new System(0, "system", TechLevel.PRE_AGRICULTURE, Characteristic.NOSPECIALRESOURCES, new Coordinate(0, 0)));

        double creditsBefore = player.getCredits().getCredits();
        int incargoBefore = player.getShip().getCargo().getCargoStock(Resource.Water);

        // Should not be able to do this!
        assertFalse(player.sell(Resource.Robots, 1));

        // Player credits and cargo should not have changed from failed transaction
        assertEquals(creditsBefore, player.getCredits().getCredits());
        assertEquals(incargoBefore, player.getShip().getCargo().getCargoStock(Resource.Water));
    }
    
}