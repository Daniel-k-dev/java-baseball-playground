package baseball;

public class OutputView {

    private final String gameEndMessage = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    public void showGameEnd() {
        showMessage(gameEndMessage);
    }

    public void showExceptionMessage(String message) {
        showMessage(message);
    }

    public void showGameResult(Results results) {
        showMessage(results.makeMessage());
    }

    private void showMessage(String message) {
        System.out.println(message);
    }
}
