package NumberBaseBallGame;

import java.util.List;

public class Player {
    private InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
    private Computer computer;

    private Parser parser = new Parser();
    private Balls balls;
    private String numbers;
    public Player(Computer computer) {
        this.computer = computer;
    }

    public GameStatus hadThreeStrike (GameResult gameResult) {
        GameStatus gameStatus = GameStatus.PLAY;
        if (gameResult.isThreeStrike()) {
            outputView.showGameOver();
            gameStatus = choiceGameStatus();
            selectRestart(gameStatus);
        }
        return gameStatus;
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

    private void selectRestart(GameStatus gameStatus) {
        if (GameStatus.isPlay(gameStatus)) {
            computer.setRandomBalls();
        }
    }

    private boolean isChoiceRestart(String choice) {
        return choice.equals("1");
    }

    private boolean isChoiceEnd (String choice) {
        return choice.equals("2");
    }

    public GameStatus inputValidNumber (boolean isValidInput, GameStatus gameStatus) {
        if (isValidInput) {
            balls = new Balls(parser.parseBallsNumber(numbers));
            List<BallStatus> result = balls.play(computer.getBalls());
            GameResult gameResult = new GameResult(result);
            outputView.showResult(gameResult);
            return hadThreeStrike(gameResult);
        }
        return gameStatus;
    }

    public void inputInvalidNumber(boolean isValidInput) {
        if (!isValidInput) System.out.println("잘못된 값을 입력하였습니다.");
    }

    public String getNumbers() {
        return numbers;
    }

    public void setNumbers(String numbers) {
        this.numbers = numbers;
    }
}
