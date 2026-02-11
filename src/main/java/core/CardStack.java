package core;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Represents a stack of cards (deck or hand).
 */
public class CardStack {

    private final List<Card> cards;

    public CardStack(List<Card> cards) {
        this.cards = new ArrayList<>(cards);
    }

    public static CardStack createShuffledDeck() {
        List<Card> deck = new ArrayList<>();

        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add(new Card(rank, suit));
            }
        }

        Collections.shuffle(deck);

        return new CardStack(deck);
    }

    public Card drawTopCard() {
        if (cards.isEmpty()) {
            return null;
        }
        return cards.remove(0);
    }

    public boolean isEmpty() {
        return cards.isEmpty();
    }

    public int size() {
        return cards.size();
    }

    public List<Card> getCards() {
        return new ArrayList<>(cards);
    }
}