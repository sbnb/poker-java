package in.webplay.poker;

import java.util.*;

public class Deck {

    private List<Card> cards = new ArrayList<Card>();
    private int top = 0;

    public Deck() {
        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public int size() {
        return cards.size() - top;
    }

    // deal requested number of cards, or all remaining cards in deck if less
    public List<Card> deal(int num) {
        int remaining = cards.size() - top;
        int numCards = num < remaining ? num : remaining;
        int toIndex = top + numCards;
        List<Card> toDeal = cards.subList(top, toIndex);
        top += numCards;
        return toDeal;
    }

    public void shuffle() {
        Collections.shuffle(this.cards);
        top = 0;
    }

    // display the un-dealt cards remaining in the deck
    public String toString() {
        List<Card> unDealt = cards.subList(top, cards.size());
        return Deck.cardsToString(unDealt, ",");
    }

    // return a String representation of a list of Cards
    public static String cardsToString(List<Card> cards, String delimiter) {
        StringBuilder sb = new StringBuilder();
        String prefix = "";
        for (Card card : cards) {
            sb.append(prefix);
            sb.append(card.toString());
            prefix = delimiter;
        }
        return sb.toString();
    }

    // using a default delimiter
    public static String cardsToString(List<Card> cards) {
        return Deck.cardsToString(cards, " ");
    }
}
