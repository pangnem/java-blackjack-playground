package nextstep.blackjack.view;

import nextstep.blackjack.model.AbstractParticipant;
import nextstep.blackjack.model.Dealer;
import nextstep.blackjack.model.Participant;
import nextstep.blackjack.model.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class OutputView {

    private void printDrawMessage(List<Participant> participants) {
        String allNames = getAllNames(participants);
        System.out.printf("%s에게 %s장의 카드를 나누었습니다.", allNames, AbstractParticipant.DRAW_CARD_COUNT);
    }

    private void printNameAndCards(Participant participant) {
        System.out.printf("%s: %s", participant.getName(), participant.cardsToString());
    }

    private String getAllNames(List<Participant> participants) {
        return participants.stream()
                .map(Participant::getName)
                .collect(Collectors.joining(", "));
    }

    private void printEmptyLine() {
        System.out.println();
    }

    public void outputCards(Participant participant) {
        printNameAndCards(participant);
        printEmptyLine();
    }

    public void outputDealerHitMessage() {
        System.out.format("딜러는 %s이하라 한장의 카드를 더 받았습니다.", Dealer.HIT_SCORE);
        printEmptyLine();
    }

    public void outputCards(List<Player> players, Dealer dealer) {
        List<Participant> participants = toParticipants(players, dealer);
        printDrawMessage(participants);
        printEmptyLine();

        participants.forEach(this::outputCards);
        printEmptyLine();
    }

    private List<Participant> toParticipants(List<Player> players, Dealer dealer) {
        return Stream.of(players, List.of(dealer))
                .flatMap(Collection::stream)
                .collect(Collectors.toList());
    }
}
