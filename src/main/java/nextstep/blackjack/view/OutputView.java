package nextstep.blackjack.view;

import nextstep.blackjack.model.AbstractParticipant;
import nextstep.blackjack.model.Participant;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {
    public void outputCards(List<Participant> participants) {
        printDrawMessage(participants);
        printEmptyLine();

        participants.forEach(participant -> {
            printNameAndCards(participant);
            printEmptyLine();
        });
    }

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

}
