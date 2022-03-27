package nextstep.blackjack.model;

public class Player extends AbstractParticipant {
    private final PlayerInfo playerInfo;
    private boolean isStay;

    public Player(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
        this.isStay = false;
    }

    @Override
    public String getName() {
        return this.playerInfo.getName();
    }

    @Override
    public boolean isPlayer() {
        return true;
    }

    public boolean isStay() {
        return this.isStay;
    }

    public void stay() {
        this.isStay = true;
    }

    @Override
    public boolean canHit() {
        return !this.isBust() && !this.isStay();
    }
}
