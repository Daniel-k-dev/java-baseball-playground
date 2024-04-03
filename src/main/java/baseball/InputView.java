package baseball;

import java.util.Scanner;

public class InputView {

    private final GameOverInputValidator inputValidator = new GameOverInputValidator();
    private final String inputBallNumberMessage = "숫자를 입력해 주세요 : ";
    private final String GameOverMessage = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public String showInputBallNumberView() {
        showMessage(inputBallNumberMessage);
        return inputString();
    }

    public String showGameOver() {
        showMessage(GameOverMessage + "\n");
        String userInput = inputString();
        inputValidator.check(userInput);
        return userInput;
    }

    private void showMessage(String message) {
        System.out.print(message);
    }

    private String inputString () {
        Scanner in = new Scanner(System.in);
        return in.nextLine();
    }

}
