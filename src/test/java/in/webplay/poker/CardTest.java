package in.webplay.poker;

import org.junit.Test;
import static org.junit.Assert.*;

public class CardTest {
    @Test
    public void canConstructACardWithRankAndSuit() {
        Card.Rank rank = Card.Rank.NINE;
        Card.Suit suit = Card.Suit.HEART;
        Card card = new Card(rank, suit);
        assertEquals(rank, card.getRank());
        assertEquals(suit, card.getSuit());
    }

    @Test
    public void canConstructACardWithString() {
        String value = "8c";
        Card card = Card.fromString(value);
        assertEquals(Card.Rank.EIGHT, card.getRank());
        assertEquals(Card.Suit.CLUB, card.getSuit());
    }

    @Test
    public void canGetCardAsString() {
        String value = "Ah";
        Card card = Card.fromString(value);
        String cardAsString = card.toString();
        assertEquals(value, cardAsString);
    }

}
