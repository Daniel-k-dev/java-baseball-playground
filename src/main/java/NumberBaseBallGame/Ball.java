package NumberBaseBallGame;

public class Ball {
    private final int number, index;

    public Ball(int index, int number) {
        this.number = number;
        this.index = index;
    }

    public int getNumber() {
        return number;
    }

    public int getIndex() {
        return index;
    }

    public boolean equals(Ball ball) {
        return number == ball.number && index == ball.index;
    }

    public boolean isEqualsNumber(Ball comBall) {
        return this.number == comBall.getNumber();
    }

    public BallStatus play(Ball ball) {
        if (BallStatus.isStrike(this, ball)) {
            return BallStatus.STRIKE;
        }
        if (BallStatus.isBall(this, ball)) {
            return BallStatus.BALL;
        }
        return BallStatus.NOTHING;
    }
}
