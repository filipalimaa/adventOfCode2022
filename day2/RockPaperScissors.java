package day2;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class RockPaperScissors {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("input.txt"));
        int totalScore = 0;

        for (String line: lines) {
            String[] parts = line.split(" ");
            char opponent = parts[0].charAt(0);
            char player = parts[1].charAt(0);

            int roundScore = getRoundScore(opponent, player);
            totalScore += roundScore;
        }

        System.out.println("Total Score: " + totalScore);
    }

    private static int getRoundScore(char opponent, char player) {
        int opponentMove = decodeMove(opponent);
        int playerMove = decodeMove(player);

        int shapeScore = playerMove + 1;

        int outcomeScore;

        if (playerMove == opponentMove) {
            outcomeScore = 3;
        } else if ((playerMove - opponentMove + 3) % 3 == 1) {
            outcomeScore = 6;
        } else {
            outcomeScore = 0;
        }

        return shapeScore + outcomeScore;
    }

    private static int decodeMove(char c) {
        return switch (c) {
            case 'A', 'X' -> 0;
            case 'B', 'Y' -> 1;
            case 'C', 'Z' -> 2;
            default -> throw new IllegalArgumentException("Invalid move: " + c);
        };
    }
}
