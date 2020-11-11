import java.util.Random;

public class snakeAndLadderSimulator {
	// UC1 starting with positio 0
	int start() {
		int start = 0;
		System.out.println("Starting position=" + start);
		return start;
	}

	// UC2 roll the dice
	int rollDice() {
		Random random = new Random();
		int dice = random.nextInt(6) + 1;
		System.out.println("Dice=" + dice);
		return dice;
	}

	// UC3 Playing the game by making choice
	// UC5 Refactor to check position less than 100 
	int play(int position, int dice) {
		Random random = new Random();
		int choice = random.nextInt(3);
		switch (choice) {
		case 0:
			System.out.println("No play ---- position = " + position);
			break;
		case 1:
			position += dice;
			if ( position>100 )
				position-=dice;
			System.out.println("Ladder ---- position = " + position);
			break;
		case 2:
			position -= dice;
			System.out.println("Snake ---- position = " + position);

		}
		return position;
	}

	// UC4 Repeating till winner position
	void Check(int position) {
		while (true) {
			if (position < 0) {
				position = 0;
				System.out.println("position=" + position);
			}
			if (position == 100) {
				System.out.println("winner");
				return;
			}
			int dice = rollDice();
			position = play(position, dice);
		}
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Snake & Ladder Simulator");
		snakeAndLadderSimulator game = new snakeAndLadderSimulator();

		int position = game.start();
		int dice = game.rollDice();
		position = game.play(position, dice);
		game.Check(position);
	}

}