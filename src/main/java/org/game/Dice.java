import java.util.Random;

/**
 * Represents a dice used for rolling in the Magical Arena game.
 */
public class Dice {
    private Random random; // Random object for generating dice rolls

    /**
     * Constructor to initialize the Dice object.
     */
    public Dice() {
        this.random = new Random();
    }

    /**
     * Rolls the dice to generate a random value between 1 and 6.
     * @return The result of the dice roll.
     */
    public int roll() {
        return random.nextInt(6) + 1; // 1-6 range for a 6-sided dice
    }
}
