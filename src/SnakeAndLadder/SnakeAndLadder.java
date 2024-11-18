package SnakeAndLadder;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SnakeAndLadder {
    private final int WINNING_POSITION = 100;
    private Map<Integer, Integer> snakes;
    private Map<Integer, Integer> ladders;
    private int[] playerPositions;
    private int currentPlayer;

    public SnakeAndLadder(int players) {
        snakes = new HashMap<>();
        ladders = new HashMap<>();
        playerPositions = new int[players];
        Arrays.fill(playerPositions, 0);
        currentPlayer = 0;
        initializeBoard();
    }

    private void initializeBoard() {

        // Add snakes
        snakes.put(16, 6);
        snakes.put(47, 26);
        snakes.put(49, 11);
        snakes.put(56, 53);
        snakes.put(62, 19);
        snakes.put(64, 60);
        snakes.put(87, 24);
        snakes.put(93, 73);
        snakes.put(95, 75);
        snakes.put(98, 78);

        // Add some ladders
        ladders.put(1, 38);
        ladders.put(4, 14);
        ladders.put(9, 31);
        ladders.put(21, 42);
        ladders.put(28, 84);
        ladders.put(36, 44);
        ladders.put(51, 67);
        ladders.put(71, 91);
        ladders.put(80, 99);
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Player " + (currentPlayer + 1) + "'s turn. Press Enter to roll the dice.");
            scanner.nextLine();
            int diceRoll = rollDice();
            System.out.println("Player " + (currentPlayer + 1) + " rolled a " + diceRoll);
            movePlayer(diceRoll);
            if (playerPositions[currentPlayer] == WINNING_POSITION) {
                System.out.println("Player " + (currentPlayer + 1) + " wins!");
                break;
            }
            currentPlayer = (currentPlayer + 1) % playerPositions.length;
        }
        scanner.close();
    }

    private int rollDice() {
        return (int) (Math.random() * 6) + 1;
    }

    private void movePlayer(int diceRoll) {
        int newPosition = playerPositions[currentPlayer] + diceRoll;
        if (newPosition > WINNING_POSITION) {
            newPosition = playerPositions[currentPlayer];
        } else {
            if (snakes.containsKey(newPosition)) {
                System.out.println("Player " + (currentPlayer + 1) + " got bitten by a snake!");
                newPosition = snakes.get(newPosition);
            } else if (ladders.containsKey(newPosition)) {
                System.out.println("Player " + (currentPlayer + 1) + " climbed a ladder!");
                newPosition = ladders.get(newPosition);
            }
        }
        playerPositions[currentPlayer] = newPosition;
        System.out.println("Player " + (currentPlayer + 1) + " is now on square " + newPosition);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of players: ");
        int players = scanner.nextInt();
        SnakeAndLadder game = new SnakeAndLadder(players);
        game.playGame();
        scanner.close();
    }
}
