package core;
import java.util.Objects;      //dashCode()

/**
 * Represents a single playing card.
 */
public class Card {    //new type defined

    public enum Suit {
        HEARTS("♥️"),
        DIAMONDS("♦️"),
        CLUBS("♣️"),
        SPADES("♠️");

        private final String symbol;

        Suit(String symbol) {
            this.symbol = symbol;
        }

        public String getSymbol() {
            return symbol;
        }
    }

    public enum Rank {
        TWO(2, "2"),
        THREE(3, "3"),
        FOUR(4, "4"),
        FIVE(5, "5"),
        SIX(6, "6"),
        SEVEN(7, "7"),
        EIGHT(8, "8"),
        NINE(9, "9"),
        TEN(10, "10"),
        JACK(11, "J"),
        QUEEN(12, "Q"),
        KING(13, "K"),
        ACE(14, "A");

        private final int number;
        private final String display;

        Rank(int value, String display) {
            this.number = value;
            this.display = display;
        }
        public int getValue() {
            return number;
        }
        public String getDisplay() {
            return display;
        }
    }
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    public int compareRank(Card other) {
        return Integer.compare(this.rank.getValue(), other.rank.getValue());
    }

    @Override public String toString() {
        return rank.getDisplay() + suit.getSymbol();
    }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Card card)) return false;
        return rank == card.rank && suit == card.suit;
    }
    @Override public int hashCode() {
        return Objects.hash(rank, suit);
    }
}