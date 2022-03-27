package nextstep.blackjack.model;

public interface Participant {
    String getName();

    String cardsToString();

    boolean isBust();

    Card hit();

    boolean isPlayer();

    boolean canHit();
}
