package nextstep.blackjack.model;

public class Dealer extends AbstractParticipant {
    public static final int HIT_SCORE = 16;

    @Override
    public String getName() {
        return "딜러";
    }

    @Override
    public boolean canHit() {
        int sum = this.getSum();

        return sum <= HIT_SCORE;
    }

    @Override
    public boolean isPlayer() {
        return false;
    }
}
