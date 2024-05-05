package org.game;

/**
 * Represents a player in the Magical Arena game.
 */
public class Player {
    private int health; // Health attribute of the player
    private int strength; // Strength attribute of the player
    private int attack; // Attack attribute of the player

    /**
     * Creates a new Player instance.
     * @param health The initial health of the player.
     * @param strength The strength attribute of the player.
     * @param attack The attack attribute of the player.
     */
    public Player(int health, int strength, int attack) {
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    /**
     * Gets the current health of the player.
     * @return The health of the player.
     */
    public int getHealth() {
        return health;
    }

    /**
     * Sets the health of the player.
     * @param health The new health value.
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * Gets the current strength of the player.
     * @return The strength of the player.
     */
    public int getStrength() {
        return strength;
    }

    /**
     * Sets the strength of the player.
     * @param strength The new health value.
     */
    public void setStrength(int strength) {
        this.strength = strength;
    }

    /**
     * Performs an attack action on the defender.
     * @param dice The dice object used for rolling.
     * @param defender The player being attacked.
     */
    public void attack(Dice dice, Player defender) {
        int roll = dice.roll(); // Roll the dice to determine attack strength
        int damage = roll * attack; // Calculate damage based on attack attribute and dice roll
        defender.defend(dice, damage); // Call defender's defend method with calculated damage
    }

    /**
     * Defends against an attack, reducing damage based on defense strength.
     * @param dice The dice object used for rolling.
     * @param damage The incoming damage to defend against.
     */
    public void defend(Dice dice, int damage) {
        int roll = dice.roll(); // Roll the dice to determine defense strength
        int defense = roll * strength; // Calculate defense based on strength attribute and dice roll
        int damageTaken = Math.max(0, damage - defense); // Ensure damage taken is non-negative
        health -= damageTaken; // Reduce health by the remaining damage
    }

    /**
     * Checks if the player is alive.
     * @return True if the player's health is greater than 0, false otherwise.
     */
    public boolean isAlive() {
        return health > 0;
    }
}
