package NumberBaseBallGame;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private InputView inputView = new InputView();
    private Validator validator = new Validator();
    private Computer computer = new Computer();
    private OutputView outputView = new OutputView();
    private Player player = new Player(computer);
    private GameStatus gameStatus = GameStatus.PLAY;
    public void play() {
        while(GameStatus.isPlay(gameStatus)) {
            inputView.show();
            player.setNumbers(inputView.inputNumbers());

            boolean validatedResult = validator.isValid(player.getNumbers());

            gameStatus = player.inputValidNumber(validatedResult, gameStatus);
            player.inputInvalidNumber(validatedResult);
        }
    }
}
