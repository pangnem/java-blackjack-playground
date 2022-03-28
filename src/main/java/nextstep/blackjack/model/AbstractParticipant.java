package nextstep.blackjack.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractParticipant implements Participant {
    public static final int DRAW_CARD_COUNT = 2;
    private static final int BLACKJACK_SCORE = 21;

    protected List<Card> cards = drawCards();

    private List<Card> drawCards() {
        List<Card> cards = new ArrayList<>();

        for (int i = 0; i < DRAW_CARD_COUNT; i++) {
            Card card = Card.draw();
            cards.add(card);
        }

        return cards;
    }

    @Override
    public String cardsToString() {
        return this.cards.stream()
                .map(Card::toString)
                .collect(Collectors.joining(", "));
    }

    @Override
    public boolean isBust() {
        int sum = getSum();

        return sum > BLACKJACK_SCORE;
    }

    @Override
    public Card hit() {
        Card card = Card.draw();
        this.cards.add(card);

        return card;
    }

    @Override
    public boolean isBlackJack() {
        int sum = getSum();

        return sum == BLACKJACK_SCORE;
    }

    protected int getSum() {
        return cards.stream()
                .map(Card::getRank)
                .map(Card.Rank::getScore)
                .reduce(Integer::sum)
                .orElseThrow(RuntimeException::new);
    }

    /**
     * 카드 목록을 설정합니다.
     * <p>
     * 현재는 테스트 편의를 위해 테스트 코드에서만 호출하고 있습니다.
     *
     * @param cards 바꿀 카드 목록
     */
    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
