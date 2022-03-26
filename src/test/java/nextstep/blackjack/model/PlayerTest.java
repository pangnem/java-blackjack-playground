package nextstep.blackjack.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerTest {

    @Test
    void getName() {
        String name = "name";
        Player player = new Player(new PlayerInfo(name, 10000));

        String actual = player.getName();

        assertThat(actual).isEqualTo(name);
    }
}
