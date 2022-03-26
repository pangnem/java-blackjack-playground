package nextstep.blackjack.model;

public class Player extends Participant {
    private final PlayerInfo playerInfo;

    public Player(PlayerInfo playerInfo) {
        this.playerInfo = playerInfo;
    }

    @Override
    public String getName() {
        return this.playerInfo.getName();
    }
}
