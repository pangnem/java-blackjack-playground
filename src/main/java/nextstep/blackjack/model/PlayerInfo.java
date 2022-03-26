package nextstep.blackjack.model;

public class PlayerInfo {
    private final String name;
    private final int amount;

    public PlayerInfo(String name, int amount) {
        this.name = name;
        this.amount = amount;
    }

    public String getName() {
        return this.name;
    }
}
