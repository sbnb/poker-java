package in.webplay.poker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Hand {

	private final List<Card> cards;

	// create a new Hand with cards sorted in descending rank order
	public Hand(List<Card> cards) {
		this.cards = cards;
		Collections.sort(this.cards, compareByRank);
	}

	// compare Cards by their rank, for a descending order
	Comparator<Card> compareByRank = new Comparator<Card>() {
		@Override
		public int compare(Card c1, Card c2) {
			return c2.getRank().ordinal() - c1.getRank().ordinal();
		}
	};

	// build a Hand from an "Ah Qd Qh 7s Th" style string
	public static Hand fromString(String cardStr) {
		List<Card> cards = new ArrayList<Card>();
		String[] cardTokens = cardStr.split("\\s+");
		for (String cardToken : cardTokens) {
			cards.add(Card.fromString(cardToken));
		}
		return new Hand(cards);
	}

	// display hand in standard poker notation: "As Kd Th 7h 4d"
	@Override
	public String toString() {
		return Deck.cardsToString(this.cards, " ");
	}

	// return the highest number of matching suits
	public int numSameSuits() {
		int frequency[] = { 0, 0, 0, 0 };
		for (Card card : cards) {
			Card.Suit suit = card.getSuit();
			frequency[suit.getIndex()] += 1;
		}
		return max(frequency);
	}

	private int max(int array[]) {
		int max = 0;
		for (int i : array) {
			max = i > max ? i : max;
		}
		return max;
	}

	// return the highest number of consecutive ranked cards (for straights)
	public int numConnected() {
		Card prevCard = cards.get(0);
		int run = 1;
		int max = 0;

		for (Card card : cards) {
			if (card.oneLessThan(prevCard)) {
				run += 1;
				max = run > max ? run : max;
			} else {
				run = 1;
			}
			prevCard = card;
		}

		// special case: ace low straight detection
		if (max == 4 && isLowStraight()) {
			return 5;
		}
		return max;
	}

	private static final Card.Rank LOW_STRAIGHT_RANKS[] = { Card.Rank.ACE,
			Card.Rank.FIVE, Card.Rank.FOUR, Card.Rank.THREE, Card.Rank.TWO };

	// a low straight has sorted ranks: A,5,4,3,2
	private boolean isLowStraight() {
		Card.Rank ranks[] = new Card.Rank[5];
		for (int idx = 0; idx < ranks.length; idx += 1) {
			ranks[idx] = cards.get(idx).getRank();
		}
		return Arrays.equals(LOW_STRAIGHT_RANKS, ranks);
	}

}
