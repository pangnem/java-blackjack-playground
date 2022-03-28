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

        checkHitOrStay(players, dealer);
    }

    private void checkHitOrStay(List<Player> players, Dealer dealer) {
        players.stream()
                .filter(player -> !player.isBlackJack())
                .forEach(this::checkHitOrStay);

        if (!dealer.isBlackJack()) {
            checkHitOrStay(dealer);
        }
    }

    private void checkHitOrStay(Dealer dealer) {
        while (dealer.canHit()) {
            outputView.outputDealerHitMessage();
            dealer.hit();
            outputView.outputCards(dealer);
        }
    }

    private void checkHitOrStay(Player player) {
        String hitWhether = inputView.inputHitWhether(player);
        if ("N".equals(hitWhether)) {
            return;
        }

        player.hit();
        outputView.outputCards(player);
        if (player.isBust()) {
            return;
        }

        checkHitOrStay(player);
    }

}
