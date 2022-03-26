package nextstep.blackjack.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class AbstractParticipantTest {

    @Test
    void cardsToString() {
        AbstractParticipant abstractParticipant = new Dealer();

        String actual = abstractParticipant.cardsToString();

        assertThat(actual).matches("[0-9]{1,2}[가-힣]+, [0-9]{1,2}[가-힣]+");
    }
}
