import java.util.Random;

public class snakeAndLadderSimulator {
	// UC1 starting with positio 0
	void start() {
		int start = 0;
		System.out.println("Starting position=" + start);
	}

	// UC2 roll the dice
	void rollDice() {
		Random roll = new Random();
		int dice = roll.nextInt(6) + 1;
		System.out.println("Dice=" + dice);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Snake & Ladder Simulator");
		snakeAndLadderSimulator game = new snakeAndLadderSimulator();
		game.start();
		game.rollDice();

	}

}

