package NumberBaseBallGame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private InputView inputView = new InputView();
    private Validator validator = new Validator();
    private Computer computer = new Computer();
    private OutputView outputView = new OutputView();
    private GameStatus gameStatus = GameStatus.PLAY;
    private Balls computerBalls = computer.initializeBalls();
    public void play() {
        while(GameStatus.isPlay(gameStatus)) {
            inputView.show();
            String numbers = inputView.inputNumber();

            boolean isValidInput = validator.isValid(numbers);

            inputValidNumber(isValidInput, numbers);
            inputInvalidNumber(isValidInput);
        }
    }

    private void inputValidNumber (boolean isValidInput, String numbers) {
        if (isValidInput) {
            Balls userBalls = new Balls(parseBallsNumber(numbers));
            List<BallStatus> statuses = userBalls.play(computerBalls);
            GameResult gameResult = new GameResult(statuses);
            outputView.showResult(gameResult);
            threeStriked(gameResult);
        }
    }

    private void inputInvalidNumber(boolean isValidInput) {
        if (!isValidInput) System.out.println("잘못된 값을 입력하였습니다.");
    }

    private void threeStriked (GameResult gameResult) {
        if (gameResult.isThreeStrike()) {
            showGameOver();
            gameStatus = choiceGameStatus();
            selectRestart();
        }
    }

    private void selectRestart() {
        if (GameStatus.isPlay(gameStatus)) {
            computerBalls = computer.initializeBalls();
        }
    }

    private GameStatus choiceGameStatus() {
        String choice = inputView.choiceRestart();
        if (isChoiceRestart(choice)) {
            return GameStatus.PLAY;
        }
        if (isChoiceEnd(choice)) {
            return GameStatus.END;
        }
        outputView.showIllegalInput();
        return choiceGameStatus();
    }

    private boolean isChoiceRestart(String choice) {
        return choice.equals("1");
    }

    private boolean isChoiceEnd (String choice) {
        return choice.equals("2");
    }

    private List<Integer> parseBallsNumber(String numbers) {
        List<Integer> parsedNumbers = new ArrayList<>();
        for (int index = 0; index < numbers.length(); index++) {
            String number = numbers.substring(index, index + 1);
            parsedNumbers.add(Integer.parseInt(number));
        }
        return parsedNumbers;
    }

    private void showGameOver() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료\n" +
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
