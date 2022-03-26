package nextstep.blackjack.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CardTest {

    @Test
    void draw() {
        Card drawedCard = Card.draw();

        assertThat(drawedCard.toString()).matches("[0-9]{1,2}[가-힣]+");
    }

    @Test
    void card_toString() {
        Card.Rank rank = Card.Rank.THREE;
        Card.Suit suit = Card.Suit.DIAMONDS;

        Card card = new Card(rank, suit);

        assertThat(card.toString()).isEqualTo("3다이아몬드");
    }
}
