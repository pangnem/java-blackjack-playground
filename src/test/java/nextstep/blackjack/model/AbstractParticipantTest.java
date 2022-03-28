package nextstep.blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractParticipantTest {
    private AbstractParticipant abstractParticipant;

    @BeforeEach
    void setUp() {
        this.abstractParticipant = new Dealer();
    }

    @Test
    void cardsToString() {
        String actual = abstractParticipant.cardsToString();

        assertThat(actual).matches("[0-9]{1,2}[가-힣]+, [0-9]{1,2}[가-힣]+");
    }

    @Test
    void isBustWithNotExceedBustScoreParticipant() {
        List<Card> cards = Arrays.asList(
                new Card(Card.Rank.KING),
                new Card(Card.Rank.SEVEN),
                new Card(Card.Rank.FOUR)
        );
        abstractParticipant.setCards(cards);

        boolean actual = abstractParticipant.isBust();

        assertThat(actual).isFalse();
    }

    @Test
    void isBustWithExceedBustScoreParticipant() {
        List<Card> cards = Arrays.asList(
                new Card(Card.Rank.JACK),
                new Card(Card.Rank.JACK),
                new Card(Card.Rank.DEUCE)
        );
        abstractParticipant.setCards(cards);

        boolean actual = abstractParticipant.isBust();

        assertThat(actual).isTrue();
    }

    @Test
    void getSum() {
        List<Card> cards = Arrays.asList(
                new Card(Card.Rank.JACK),
                new Card(Card.Rank.JACK)
        );
        abstractParticipant.setCards(cards);

        int actual = abstractParticipant.getSum();

        assertThat(actual).isEqualTo(
                Card.Rank.JACK.getScore() +
                        Card.Rank.JACK.getScore()
        );
    }

    @Test
    void isBlackJackWithRank21() {
        assertThat(abstractParticipant.isBlackJack()).isFalse();

        List<Card> cards = Arrays.asList(
                new Card(Card.Rank.JACK),
                new Card(Card.Rank.ACE)
        );
        abstractParticipant.setCards(cards);

        boolean actual = abstractParticipant.isBlackJack();

        assertThat(actual).isTrue();
    }
}
