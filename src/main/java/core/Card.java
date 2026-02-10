

public record Card (Rank rank, Suit suit){
    static public enum Suit {
        HEARTS, DIAMONDS, CLUBS, SPADES
    }
    static public enum Rank {TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE}

    public int value() {
        return switch (this) {
            case TWO -> 2;
            case THREE -> 3;
            case FOUR -> 4;
            case FIVE -> 5;
            case SIX -> 6;
            case SEVEN -> 7;
            case EIGHT -> 8;
            case NINE -> 9;
            case TEN, kING, JACk,QUEEN -> 10;
            case ACE -> 11;

        }
    }

    }