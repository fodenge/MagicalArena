package org.game;

/**
 * Represents the Magical Arena where players compete in matches.
 */
public class MagicalArena {
    private Player playerA; // The first player in the arena
    private Player playerB; // The second player in the arena
    private Dice dice; // The dice used for rolling in the arena

    /**
     * Constructor to initialize the MagicalArena object with players and dice.
     * @param playerA The first player in the arena.
     * @param playerB The second player in the arena.
     * @param dice The dice used for rolling in the arena.
     */
    public MagicalArena(Player playerA, Player playerB, Dice dice) {
        this.playerA = playerA;
        this.playerB = playerB;
        this.dice = dice;
    }

    /**
     * Starts a match between playerA and playerB in the arena.
     * The match continues until one of the players' health reaches 0.
     */
    public void startMatch() {
        while (playerA.isAlive() && playerB.isAlive()) {
            playTurn(playerA, playerB); // PlayerA attacks PlayerB
            if (!playerB.isAlive()) break; // Exit loop if PlayerB is defeated
            playTurn(playerB, playerA); // PlayerB attacks PlayerA
        }
        determineWinner(); // Determine the winner of the match
    }

    /**
     * Performs a turn where the attacker attacks the defender.
     * @param attacker The attacking player.
     * @param defender The defending player.
     */
    private void playTurn(Player attacker, Player defender) {
        attacker.attack(dice, defender); // Attacker performs an attack on the defender
    }

    /**
     * Determines the winner of the match based on the players' health.
     */
    private void determineWinner() {
        if (playerA.isAlive() && !playerB.isAlive()) {
            System.out.println("Player A wins!");
        } else if (!playerA.isAlive() && playerB.isAlive()) {
            System.out.println("Player B wins!");
        } else {
            System.out.println("It's a draw!");
        }
    }
}
