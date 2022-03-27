package nextstep.blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {
    private Player player;

    @BeforeEach
    void setUp() {
        player = new Player(new PlayerInfo("name", 10000));
    }

    @Test
    void getName() {
        String actual = player.getName();

        assertThat(actual).isEqualTo("name");
    }

    @Test
    void isPlayer() {
        boolean actual = player.isPlayer();

        assertThat(actual).isTrue();
    }

    @Test
    void stay() {
        assertThat(player.isStay()).isFalse();

        player.stay();

        assertThat(player.isStay()).isTrue();
    }

    @Test
    void canHitWithStay() {
        assertThat(player.canHit()).isTrue();

        player.stay();
        assertThat(player.canHit()).isFalse();
    }

    @Test
    void canHitWithBust() {
        assertThat(player.canHit()).isTrue();

        List<Card> cards = Arrays.asList(
                new Card(Card.Rank.JACK),
                new Card(Card.Rank.JACK),
                new Card(Card.Rank.JACK)
        );
        player.setCards(cards);

        assertThat(player.isBust()).isTrue();
        assertThat(player.canHit()).isFalse();
    }
}
