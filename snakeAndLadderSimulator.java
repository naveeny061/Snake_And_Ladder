import java.util.Random;

public class snakeAndLadderSimulator {
	int count = 0;

	// UC1 starting with position 0
	int start() {
		int start = 0;
		System.out.println("  Starting position=" + start);
		return start;
	}

	// UC2 roll the dice
	int rollDice() {
		count++;
		Random random = new Random();
		int dice = random.nextInt(6) + 1;
		System.out.println("  Dice=" + dice);
		return dice;
	}

	// UC3 Playing the game by making choice
	// UC5 Refactor to check position less than 100
	int play(int position, int dice) {
		Random random = new Random();
		int choice = random.nextInt(3);
		switch (choice) {
		case 0:
			System.out.println("  No play ---- position = " + position);
			break;
		case 1:
			position += dice;
			if (position > 100)
				position -= dice;
			System.out.println("  Ladder ---- position = " + position);
			break;
		case 2:
			position -= dice;
			System.out.println("  Snake ---- position = " + position);

		}
		if (choice == 1) {
			if(position==100)
				return position;
			dice=rollDice();
			play(position, dice);
		}
		return position;
	}

	// UC4 Repeating till winner position
	// UC7 Refactor for 2 players
	void Check(int position1, int position2) {
		while (true) {
			if (position1 < 0) {
				position1 = 0;
				System.out.println("position1=" + position1);
			}
			if (position2 < 0) {
				position2 = 0;
				System.out.println("position2=" + position1);
			}
			if (position1 == 100) {
				System.out.println("Player 1 is winner");
				return;
			}
			if (position2 == 100) {
				System.out.println("Player 2 is winner");
				return;
			}
			System.out.println("Player1");
			int dice1 = rollDice();
			position1 = play(position1, dice1);
			System.out.println("Player2");
			int dice2 = rollDice();
			position2 = play(position2, dice2);
		}
	}

	// UC6 number of dice roll for winning
	void dice() {
		System.out.println("Total Dice Roll " + count);
	}

	public static void main(String[] args) {
		System.out.println("Welcome to Snake & Ladder Simulator");
		snakeAndLadderSimulator player1 = new snakeAndLadderSimulator();
		snakeAndLadderSimulator player2 = new snakeAndLadderSimulator();
		snakeAndLadderSimulator play = new snakeAndLadderSimulator();

		System.out.print("Player1");
		int position1 = player1.start();
		System.out.print("Player2");
		int position2 = player2.start();
		System.out.print("Player1");
		int dice1 = player1.rollDice();
		System.out.print("Player2");
		int dice2 = player2.rollDice();
		System.out.print("Player1");
		position1 = player1.play(position1, dice1);
		System.out.print("Player2");
		position2 = player2.play(position2, dice2);
		play.Check(position1, position2);
		play.dice();
	}

}
