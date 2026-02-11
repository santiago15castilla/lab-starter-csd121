package core;
import java.util.List;

/**
 * Coordinates the game logic.
 */
public class HighCardGame {
    private final Player player1;
    private final Player player2;
    private int player1Score = 0;
    private int player2Score = 0;

    public HighCardGame(String name1, String name2) {

        CardStack deck = CardStack.createShuffledDeck();

        List<Card> allCards = deck.getCards();

        CardStack hand1 = new CardStack(allCards.subList(0, 26));
        CardStack hand2 = new CardStack(allCards.subList(26, 52));

        this.player1 = new Player(name1, hand1);
        this.player2 = new Player(name2, hand2);
    }

    public boolean canPlay() {
        return player1.hasCards() && player2.hasCards();
    }

    public String playRound() {

        Card card1 = player1.drawCard();
        Card card2 = player2.drawCard();

        int comparison = card1.compareRank(card2);

        if (comparison > 0) {
            player1Score++;
            return player1.getName() + " wins! (" + card1 + " vs " + card2 + ")";
        } else if (comparison < 0) {
            player2Score++;
            return player2.getName() + " wins! (" + card1 + " vs " + card2 + ")";
        } else {
            return "Tie! (" + card1 + " vs " + card2 + ")";
        }
    }
    public String getScore() {
        return player1.getName() + ": " + player1Score +
                " | " +
                player2.getName() + ": " + player2Score;
    }
    public String getFinalWinner() {
        if (player1Score > player2Score) {
            return player1.getName() + " wins the game!";
        } else if (player2Score > player1Score) {
            return player2.getName() + " wins the game!";
        } else {
            return "The game ends in a tie!";
        }
    }
}