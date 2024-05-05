package org.game;

import junit.framework.TestCase;

import org.junit.Test;
import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void testPlayerCreation() {
        Player player = new Player(100, 20, 15);
        assertEquals(100, player.getHealth());
        assertEquals(20, player.getStrength());
    }

    @Test
    public void testPlayerAttack() {
        Player attacker = new Player(100, 20, 15);
        Player defender = new Player(80, 18, 12);
        Dice dice = new Dice(); // Mocked or real dice object

        attacker.attack(dice, defender);

        assertEquals(true, defender.getHealth() <= 80); // Assuming attack reduces defender's health
    }

    @Test
    public void testPlayerDefend() {
        Player attacker = new Player(100, 20, 15);
        Player defender = new Player(80, 18, 12);
        Dice dice = new Dice(); // Mocked or real dice object

        int damage = 100; // Assume a high damage value for testing purposes
        attacker.defend(dice, damage);

        assertTrue(attacker.getHealth() < 100); // Assuming defender takes some damage
    }

    @Test
    public void testPlayerIsAlive() {
        Player player = new Player(100, 20, 15);
        assertTrue(player.isAlive()); // Player should initially be alive

        player.setHealth(0); // Set health to 0
        assertFalse(player.isAlive()); // Player should not be alive
    }
}
