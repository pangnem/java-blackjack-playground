package nextstep.blackjack.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PlayerInfoTest {

    @Test
    void getName() {
        String name = "name";
        PlayerInfo playerInfo = new PlayerInfo(name, 10000);

        String actual = playerInfo.getName();

        assertThat(actual).isEqualTo(name);
    }
}
