package nextstep.blackjack.controller;

import nextstep.blackjack.model.Participant;
import nextstep.blackjack.view.InputView;
import nextstep.blackjack.view.OutputView;

import java.util.List;

public class BlackJackGame {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();

    public void start() {
        List<Participant> participants = inputView.inputPlayerInfo();
        outputView.outputCards(participants);
    }
}
