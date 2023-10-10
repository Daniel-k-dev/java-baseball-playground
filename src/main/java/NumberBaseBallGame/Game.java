package NumberBaseBallGame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private InputView inputView = new InputView();
    private Validator validator = new Validator();
    private Computer computer = new Computer();
    private OutputView outputView = new OutputView();
    private GameStatus gameStatus = GameStatus.PLAY;
    public void play() {
        Balls computerBalls = computer.initializeBalls();

        while(true) {
            inputView.show();
            String numbers = inputView.inputNumber();

            if (validator.isValid(numbers)) {
                Balls userBalls = new Balls(parseBallsNumber(numbers));
                List<BallStatus> statuses = userBalls.play(computerBalls);
                GameResult gameResult = new GameResult(statuses);
                outputView.showResult(gameResult);
                if (gameResult.isThreeStrike()) {
                    showGameOver();
                    gameStatus = choiceGameStatus();
                    if (GameStatus.isPlay(gameStatus)) {
                        computerBalls = computer.initializeBalls();
                    }
                }
            }
            if (!validator.isValid(numbers)) System.out.println("잘못된 값을 입력하였습니다.");
            if (GameStatus.isEnd(gameStatus)) break;
        }
    }


    private GameStatus choiceGameStatus() {
        int choice = inputView.choiceRestart();
        if (isChoiceRestart(choice)) {
            return GameStatus.PLAY;
        }
        if (isChoiceEnd(choice)) {
            return GameStatus.END;
        }
        outputView.showIllegalInput();
        return GameStatus.PLAY;
    }

    private boolean isChoiceRestart(int choice) {
        return choice == 1;
    }
    
    private boolean isChoiceEnd (int choice) {
        return choice == 2;
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
