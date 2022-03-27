package nextstep.blackjack.view;

import nextstep.blackjack.model.Player;
import nextstep.blackjack.model.PlayerInfo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final Scanner SCANNER = new Scanner(System.in);
    private static final String INPUT_PLAYER_NAME_MESSAGE = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private static final String INPUT_AMOUNT_MESSAGE = "의 베팅금액은?";
    private static final String MORE_CARD_MESSAGE = "는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";

    public List<Player> inputPlayerInfo() {
        System.out.println(INPUT_PLAYER_NAME_MESSAGE);
        String names = SCANNER.nextLine();

        return getPlayers(names);
    }

    private List<Player> getPlayers(String names) {
        return Arrays.stream(names.split(","))
                .map(name -> {
                    System.out.println(name + INPUT_AMOUNT_MESSAGE);
                    int amount = Integer.parseInt(SCANNER.nextLine());

                    return new Player(new PlayerInfo(name, amount));
                }).collect(Collectors.toList());
    }

    public void inputHitWhether(Player player) {
        System.out.println(player.getName() + MORE_CARD_MESSAGE);

        String hitWhether = SCANNER.nextLine().toUpperCase().trim();
        if ("N".equals(hitWhether)) {
            player.stay();
        }
    }
}
