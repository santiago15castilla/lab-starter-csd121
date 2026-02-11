package core;
import java.util.Objects;

/**
 * Represents a player in the game.
 */
public class Player {

    private final String name;
    private final CardStack hand;

    public Player(String name, CardStack hand) {
        this.name = name;
        this.hand = hand;
    }

    public String getName() {
        return name;
    }

    public boolean hasCards() {
        return !hand.isEmpty();
    }

    public Card drawCard() {
        return hand.drawTopCard();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Player player)) return false;
        return Objects.equals(name, player.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}