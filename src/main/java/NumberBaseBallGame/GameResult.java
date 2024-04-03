package NumberBaseBallGame;

import java.util.List;

public class GameResult {
    int strike = 0;
    int ball = 0;

    public GameResult(List<BallStatus> statuses) {
        setGameResult(statuses);
    }

    private void setGameResult(List<BallStatus> statuses) {
        for (BallStatus status: statuses) {
            if (status == BallStatus.STRIKE) strike += 1;
            if (status == BallStatus.BALL) ball += 1;
        }
    }

    public boolean isThreeStrike() {
        return strike == 3;
    }

    public int getStrike() {
        return strike;
    }

    public int getBall() {
        return ball;
    }

    public boolean hasStrikes () {
        return strike > 0;
    }

    public boolean hasBalls () {
        return ball > 0;
    }


}
