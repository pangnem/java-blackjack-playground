package nextstep.blackjack.controller;

import nextstep.blackjack.model.Dealer;
import nextstep.blackjack.model.Player;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.OutputView;

import java.util.List;

public class BlackJackGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        List<Player> players = inputView.inputPlayerInfo();
        Dealer dealer = new Dealer();
        outputView.outputCards(players, dealer);

        players.forEach(this::checkHitOrStay);
        checkHitOrStay(dealer);
    }

    private void checkHitOrStay(Dealer dealer) {
        while (dealer.canHit()) {
            outputView.outputDealerHitMessage();
            dealer.hit();
            outputView.outputCards(dealer);
        }
    }

    private void checkHitOrStay(Player player) {
        inputView.inputHitWhether(player);
        if (!player.canHit()) {
            return;
        }

        hitAndOutputCards(player);
        if (!player.canHit()) {
            return;
        }

        checkHitOrStay(player);
    }

    private void hitAndOutputCards(Player player) {
        player.hit();
        outputView.outputCards(player);
    }
}
