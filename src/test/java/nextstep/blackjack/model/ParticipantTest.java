package nextstep.blackjack.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ParticipantTest {

    @Test
    void cardsToString() {
        Participant participant = new Dealer();

        String actual = participant.cardsToString();

        assertThat(actual).matches("[0-9]{1,2}[가-힣]+, [0-9]{1,2}[가-힣]+");
    }
}
