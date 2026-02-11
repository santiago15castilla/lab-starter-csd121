import core.HighCardGame;
import ui.Console;

public class Main {

    public static void main(String[] args) {

        Console.println("READY TO PLAY?! ");

        var names = Console.promptForNInputs("Enter player name", 2);

        var game = new HighCardGame(names.get(0), names.get(1));
        while (game.canPlay()) {

            String result = game.playRound();
            Console.println(result);
            Console.println("Score: " + game.getScore());

            if (!game.canPlay()) {
                break;
            }

            String choice = Console.promptForOption(
                    "Play another round?",
                    new String[]{"yes", "no"}
            );

            if (choice.equalsIgnoreCase("no")) {
                break;
            }
        }
        Console.println("Final Score:" + game.getScore());
        Console.println(game.getFinalWinner());

        Console.println("Game over!");
    }
}