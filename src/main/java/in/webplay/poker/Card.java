package in.webplay.poker;

public class Card {
    public enum Suit {
        HEART('h', 0),
        DIAMOND('d', 1),
        CLUB('c', 2),
        SPADE('s', 3);

        private final char shortName;
		private final int index;


        private Suit(char shortName, int index) {
            this.shortName = shortName;
            this.index = index;
        }

        public char getShortName() {
            return shortName;
        }

        public int getIndex() {
            return index;
        }

        public static Suit fromShortName(char shortName) {
            for (Suit suit : Suit.values()) {
                if (suit.getShortName() == shortName) {
                    return suit;
                }
            }
            return Suit.HEART;
        }
    };

    public enum Rank {
        TWO(2, '2'),
        THREE(3, '3'),
        FOUR(4, '4'),
        FIVE(5, '5'),
        SIX(6, '6'),
        SEVEN(7, '7'),
        EIGHT(8, '8'),
        NINE(9, '9'),
        TEN(10, 'T'),
        JACK(11, 'J'),
        QUEEN(12, 'Q'),
        KING(13, 'K'),
        ACE(14, 'A');

        private final int value;
        private final char shortName;

        private Rank(int value, char shortName) {
            this.value = value;
            this.shortName = shortName;
        }

        public char getShortName() {
            return shortName;
        }

        public static Rank fromShortName(char shortName) {
            for (Rank rank : Rank.values()) {
                if (rank.getShortName() == shortName) {
                    return rank;
                }
            }
            return Rank.TWO;
        }
    }

    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card fromString(String rankAndSuit) {
        char[] result = rankAndSuit.toCharArray();
        Rank myRank = Rank.fromShortName(result[0]);
        Suit mySuit = Suit.fromShortName(result[1]);
        return new Card(myRank, mySuit);
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
	public String toString() {
        return "" + rank.getShortName() + suit.getShortName();
    }
}
