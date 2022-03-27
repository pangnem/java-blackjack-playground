package nextstep.blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DealerTest {
    private Dealer dealer;

    @BeforeEach
    void setUp() {
        this.dealer = new Dealer();
    }

    @Test
    void getName() {
        String actual = dealer.getName();

        assertThat(actual).isEqualTo("딜러");
    }

    @Test
    void canHitWithGreaterThen17() {
        List<Card> cards = Arrays.asList(
                new Card(Card.Rank.JACK),
                new Card(Card.Rank.SIX)
        );
        dealer.setCards(new ArrayList<>(cards));

        boolean actual = dealer.canHit();

        assertThat(actual).isTrue();
    }

    @Test
    void canHitWithBiggerThen16() {
        List<Card> cards = Arrays.asList(
                new Card(Card.Rank.JACK),
                new Card(Card.Rank.SEVEN)
        );
        dealer.setCards(new ArrayList<>(cards));

        boolean actual = dealer.canHit();

        assertThat(actual).isFalse();
    }

    @Test
    void isPlayer() {
        boolean actual = dealer.isPlayer();
        
        assertThat(actual).isFalse();
    }
}
