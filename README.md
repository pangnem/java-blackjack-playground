## [NEXTSTEP 플레이그라운드의 미션 진행 과정](https://github.com/next-step/nextstep-docs/blob/master/playground/README.md)

---

## 학습 효과를 높이기 위해 추천하는 미션 진행 방법

---

1. 피드백 강의 전까지 미션 진행

> 피드백 강의 전까지 혼자 힘으로 미션 진행. 미션을 진행하면서 하나의 작업이 끝날 때 마다 add, commit
> 예를 들어 다음 숫자 야구 게임의 경우 0, 1, 2단계까지 구현을 완료한 후 push

![mission baseball](https://raw.githubusercontent.com/next-step/nextstep-docs/master/playground/images/mission_baseball.png)

---

2. 피드백 앞 단계까지 미션 구현을 완료한 후 피드백 강의를 학습한다.

---

3. Git 브랜치를 master 또는 main으로 변경한 후 피드백을 반영하기 위한 새로운 브랜치를 생성한 후 처음부터 다시 미션 구현을 도전한다.

```
git branch -a // 모든 로컬 브랜치 확인
git checkout master // 기본 브랜치가 master인 경우
git checkout main // 기본 브랜치가 main인 경우

git checkout -b 브랜치이름
ex) git checkout -b apply-feedback
```

### 블랙잭 게임 용어 정리

- 블랙잭: 처음 뽑은 카드 2장의 합이 21인 경우
- 버스트: 카드 숫자의 합이 21을 넘어 패하는 경우
- 히트: 처음 두장에서 카드를 한장 더 뽑는 것
- 스탠드, 스테이: 카드를 더 뽑지 않는 것
- 푸쉬: 플레이어와 딜러의 카드 합이 같은 경우로, 플레이어의 베팅금액은 반환됨

### 궁금한점 / 이슈

- [x] 카드 뽑는것은 랜덤으로 해야 되나?
    - 우선 랜덤으로 진행
- [x] Ace는 어떻게 처리할 것인지?
    - 일반적으로 플레이어에게 유리한 것을 사용한다고 한다.
    - 여기서는 합이 21이 넘으면 1로, 안넘으면 11로 처리할 예정
- [x] 딜러의 수익은 어떻게 계산하는가?
    - 진 플레이어의 금액은 딜러가 가져가고, 이긴 플레이어에게는 주는 것으로 보임.

### ToDo

- [ ] BlackJackGame
    - [ ] void start()

- [x] Card
    - [x] Enum Suit
    - [x] Enum Rank
    - [x] Card draw()
        - 랜덤한 카드 하나를 반환

- [ ] (abstract) Participant
    - cards
    - [x] Participant(List<Card> cards)
    - [x] int getSum()
    - [x] Card hit()
    - [x] boolean canHit()
    - [x] (abstract) boolean isPlayer()
    - [ ] boolean isBlackJack()
    - [x] boolean isBust()

- [x] Player
    - [x] String getName()
- [x] Dealer

- [x] PlayerInfo
    - name
    - amount

- [x] InputView
    - [x] List<Participant> inputPlayerInfo()
        - [x] 이름 입력받기(쉼표로 구분)
        - [x] 베팅금액 입력받기
    - [x] List<Participant> inputHitWhether(List<Participant> participants)
        - 카드를 더 받을 것인지(hit)에 대한 여부 확인

- [ ] OutputView
    - [x] void outputCards(List<Participant> participants)
    - [ ] void outputResult(List<Participant> participants)
    - [ ] void outputRevenue(List<Participant> participants)
        - 최종 수익을 플레이어의 베팅 금액과 게임 결과에 따라 계산하여 출력한다.
