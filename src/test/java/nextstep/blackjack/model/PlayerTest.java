package nextstep.blackjack.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
}
