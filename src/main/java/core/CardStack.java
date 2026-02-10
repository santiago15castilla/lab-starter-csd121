/*
    NOTE:

    Add to this type any variables and/or methods required
    to represent/manipulate a stack (deck/hand) of playing cards.

    You MAY change this to a record/enum as you see fit.
 */
package core;

import javax.smartcardio.Card;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class  CardStack {
    public static List<Card> gimmeADeck() {
        ArrayList<Card> deck = new ArrayList<>();
        for (Card.Suit suit : Card.Rank.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                deck.add( new Card(rank, suit));
            }
        }
        Collections.shuffle(deck);
        return deck;
}
