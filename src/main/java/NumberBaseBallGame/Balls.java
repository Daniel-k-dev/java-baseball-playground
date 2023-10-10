package NumberBaseBallGame;

import java.util.ArrayList;
import java.util.List;

public class Balls {
    private List<Ball> balls = new ArrayList<>();

    public Balls(List<Integer> numbers ) {
        setBalls(numbers);
    }

    public List<BallStatus> play(Balls balls) {
        List<BallStatus> statuses = new ArrayList<>();
        List<Ball> comBalls = balls.getBalls();
        for (Ball comBall : comBalls) {
            statuses.add(this.play(comBall));
        }
        return  statuses;
    }

    public BallStatus play(Ball ball) {
        for (int index = 0; index < balls.size(); index++) {
            Ball myBall = balls.get(index);
            if (BallStatus.isStrike(myBall, ball)) return BallStatus.STRIKE;
            if (BallStatus.isBall(myBall, ball)) return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }

    private void setBalls(List<Integer> numbers) {
        for (int index = 0; index < 3; index++) {
            Ball ball = new Ball(index, numbers.get(index));
            balls.add(ball);
        }
    }

    public List<Ball> getBalls() {
        return balls;
    }
}
