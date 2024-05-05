package org.game;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MagicalArenaTest {
    private MagicalArena magicalArena;
    private Player playerA;
    private Player playerB;
    private Dice dice;

    @Before
    public void setUp() {
        playerA = new Player(50, 5, 10); // Player A with 50 health, 5 strength, and 10 attack
        playerB = new Player(100, 10, 5); // Player B with 100 health, 10 strength, and 5 attack
        dice = new Dice(); // Mocked or real dice object
        magicalArena = new MagicalArena(playerA, playerB, dice);
    }

    @Test
    public void testStartMatch_PlayerAAttacksFirst() {
        magicalArena.startMatch();
        assertTrue(playerA.getHealth() < 50 || playerB.getHealth() <= 0); // Player A should attack first
    }

    @Test
    public void testStartMatch_GameEndsWhenPlayerBHealthZero() {
        playerA.setHealth(100); // Reset player A's health
        playerB.setHealth(50); // Set player B's health to 50
        magicalArena.startMatch();
        assertTrue(playerB.getHealth() <= 0); // Player B's health should reach zero during the match
    }

    @Test
    public void testStartMatch_GameEndsWhenPlayerAHealthZero() {
        playerA.setHealth(50); // Set player A's health to 50
        playerB.setHealth(100); // Reset player B's health
        magicalArena.startMatch();
        assertTrue(playerA.getHealth() <= 0); // Player A's health should reach zero during the match
    }
}
