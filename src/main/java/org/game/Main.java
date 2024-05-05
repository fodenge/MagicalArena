package org.game;

/**
 * Main class to start the Magical Arena game.
 */
public class Main {
    public static void main(String[] args) {
        // Create two players: playerA and playerB
        Player playerA = new Player(50, 5, 10); // Player A with 50 health, 5 strength, and 10 attack
        Player playerB = new Player(100, 10, 5); // Player B with 100 health, 10 strength, and 5 attack

        // Create a dice for rolling in the arena
        Dice dice = new Dice(); // Create a 6-sided dice

        // Create a MagicalArena object with playerA, playerB, and dice
        MagicalArena arena = new MagicalArena(playerA, playerB, dice);

        // Start the match in the arena
        arena.startMatch();
    }
}
