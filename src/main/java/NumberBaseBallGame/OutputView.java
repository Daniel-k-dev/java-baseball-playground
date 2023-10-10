package NumberBaseBallGame;

public class OutputView {

    public void showResult(GameResult gameResult) {
        if (gameResult.hasBalls() && gameResult.hasStrikes()) {
            System.out.println(gameResult.getBall() + " 볼" + gameResult.getStrike() + " 스트라이크");
            return;
        };
        if (gameResult.hasStrikes()) {
            System.out.println(gameResult.getStrike() + " 스트라이크");
            return;
        }
        if (gameResult.hasBalls()) {
            System.out.println(gameResult.getBall() + " 볼");
            return;
        }
        System.out.println("낫싱");

    }

    public void showGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
    public void showIllegalInput() {
        System.out.println("잘못된 값을 입력하였습니다.");
    }
}
