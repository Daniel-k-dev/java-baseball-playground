package baseball;

import java.util.List;

public class Game {
    private InputView inputView = new InputView();
    private Random random = new Random();
    private Parser parser = new Parser();
    private OutputView outputView = new OutputView();
    public void start() {
        Balls comBalls = createComputerBalls();
        Results results = new Results();

        while (!results.isThreeStrike()) {
            results = playOneGame(results, comBalls);
        }
        outputView.showGameEnd();
        gameEnd();
    }

    private Results playOneGame(Results results, Balls comBalls) {
        try {
            results = createUserBalls().play(comBalls);
            outputView.showGameResult(results);
        } catch (RuntimeException e) {
            outputView.showExceptionMessage(e.getMessage());
        }
        return results;
    }

    private void gameEnd() {
        try {
            String userInput = inputView.showGameOver();
            checkRestartGame(userInput);
        } catch (IllegalArgumentException e) {
            outputView.showExceptionMessage(e.getMessage());
            gameEnd();
        }
    }

    private void checkRestartGame(String userInput) {
        if (userInput.equals("1")) {
            start();
        }
    }

    private Balls createComputerBalls() {
        List<Integer> comBallNumbers = random.createDifferentNumbers();
        Balls comBalls = new Balls(parser.parseToString(comBallNumbers));
        return comBalls;
    }

    private Balls createUserBalls() {
        String userInput = inputView.showInputBallNumberView();
        Balls playerBalls = new Balls(userInput);
        return playerBalls;
    }

}
