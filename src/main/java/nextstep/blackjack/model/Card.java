package nextstep.blackjack.model;

import java.util.Random;

public class Card {
    private static final Suit DEFAULT_SUIT = Suit.CLUBS;
    private final Rank rank;
    private final Suit suit;

    public Card(Rank rank) {
        this(rank, DEFAULT_SUIT);
    }

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public static Card draw() {
        Rank rank = getRandomRank();
        Suit suit = getRandomSuit();

        return new Card(rank, suit);
    }

    private static Suit getRandomSuit() {
        int randomNumber = new Random().nextInt(Suit.values().length);

        return Suit.values()[randomNumber];
    }

    private static Rank getRandomRank() {
        int randomNumber = new Random().nextInt(Rank.values().length);

        return Rank.values()[randomNumber];
    }

    @Override
    public String toString() {
        return this.rank.getScore() + this.suit.getName();
    }

    public Rank getRank() {
        return this.rank;
    }

    enum Rank {
        DEUCE(2), THREE(3), FOUR(4), FIVE(5), SIX(6),
        SEVEN(7), EIGHT(8), NINE(9), TEN(10), JACK(10), QUEEN(10), KING(10), ACE(11);

        private final int score;

        Rank(int score) {
            this.score = score;
        }

        public int getScore() {
            return this.score;
        }
    }

    enum Suit {
        CLUBS("클로버"), DIAMONDS("다이아몬드"), HEARTS("하트"), SPADES("스페이드");

        private final String name;

        Suit(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }
}
