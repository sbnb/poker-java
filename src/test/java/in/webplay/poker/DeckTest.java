package in.webplay.poker;

import java.util.*;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class DeckTest {
    Deck deck;

    @Before
    public void before() {
        deck = new Deck();
    }

    @Test
    public void canCreateAFullDeck() {
        assertEquals(52, deck.size());
    }

    @Test
    public void shouldRemoveDealtCardsFromDeck() {
        List<Card> hand = deck.deal(5);
        assertEquals(47, deck.size());
        assertEquals(5, hand.size());
    }

    @Test
    public void shouldOnlyDealAsManyCardsAsInDeck() {
        List<Card> hand = deck.deal(100);
        assertEquals(0, deck.size());
        assertEquals(52, hand.size());
    }

    @Test
    public void shouldBeAbleToShuffleDeck() {
        String preShuffle = deck.toString();
        deck.shuffle();
        String postShuffle = deck.toString();
        assertFalse(preShuffle.equals(postShuffle));
    }

    @Test
    public void shuffledDeckShouldBeFullAgain() {
        deck.deal(5);
        deck.shuffle();
        assertEquals(52, deck.size());
    }

}
