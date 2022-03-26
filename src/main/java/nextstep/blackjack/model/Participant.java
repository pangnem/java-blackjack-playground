package nextstep.blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class Participant {
    public static final int DRAW_CARD_COUNT = 2;

    protected List<Card> cards = drawCards();

    private List<Card> drawCards() {
        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < DRAW_CARD_COUNT; i++) {
            Card card = Card.draw();
            cards.add(card);
        }

        return cards;
    }

    public abstract String getName();

    public String cardsToString() {
        return this.cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
    }
}
