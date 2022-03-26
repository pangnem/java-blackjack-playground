package nextstep.blackjack.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DealerTest {

    @Test
    void getName() {
        Dealer dealer = new Dealer();

        String actual = dealer.getName();

        assertThat(actual).isEqualTo("딜러");
    }
}
