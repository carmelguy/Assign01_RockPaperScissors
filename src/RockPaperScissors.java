import java.util.Scanner;
public class RockPaperScissors
{
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean playAgain = true;

        while (playAgain) {
            String playerAMove = getPlayerMove(scanner, "Player A");
            String playerBMove = getPlayerMove(scanner, "Player B");

            displayResult(playerAMove, playerBMove);

            playAgain = askToPlayAgain(scanner);
        }
    }

    private static String getPlayerMove(Scanner scanner, String playerName) {
        while (true) {
            System.out.print(playerName + ", enter your move (R, P, S): ");
            String move = scanner.next().trim().toUpperCase();

            if (move.equals("R") || move.equals("P") || move.equals("S")) {
                return move;
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }
    }

    private static void displayResult(String playerAMove, String playerBMove) {
        if (playerAMove.equals(playerBMove)) {
            System.out.println("It's a tie!");
        } else if ((playerAMove.equals("R") && playerBMove.equals("S")) ||
                (playerAMove.equals("S") && playerBMove.equals("P")) ||
                (playerAMove.equals("P") && playerBMove.equals("R"))) {
            System.out.println("Player A wins!");
            System.out.println(getWinningMessage(playerAMove, playerBMove));
        } else {
            System.out.println("Player B wins!");
            System.out.println(getWinningMessage(playerBMove, playerAMove));
        }
    }

    private static String getWinningMessage(String winningMove, String losingMove) {
        if (winningMove.equals("R")) {
            return "Rock breaks Scissors";
        } else if (winningMove.equals("P")) {
            return "Paper covers Rock";
        } else {
            return "Scissors cuts Paper";
        }
    }

    private static boolean askToPlayAgain(Scanner scanner) {
        while (true) {
            System.out.print("Do you want to play again? [Y/N]: ");
            String choice = scanner.next().trim().toUpperCase();

            if (choice.equals("Y")) {
                return true;
            } else if (choice.equals("N")) {
                return false;
            } else {
                System.out.println("Invalid choice. Please enter Y or N.");
            }
        }
    }
}