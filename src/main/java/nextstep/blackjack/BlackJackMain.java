package nextstep.blackjack;

import nextstep.blackjack.controller.BlackJackGame;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.OutputView;

public class BlackJackMain {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView() ;

        new BlackJackGame(inputView, outputView).start();
    }
}
