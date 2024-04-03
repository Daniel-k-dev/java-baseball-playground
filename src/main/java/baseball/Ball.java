package baseball;

import java.util.Objects;

public class Ball {
    private final Number number;
    private final Position position;

    public Ball(String number, int position) {
        this.number = new Number(number);
        this.position = new Position(position);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ball ball = (Ball) o;
        return Objects.equals(number, ball.number) && Objects.equals(position, ball.position);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, position);
    }

    public Result play(Ball comBall) {
        if (this.equals(comBall)) {
            return Result.STRIKE;
        } else if (this.number.equals(comBall.number)) {
            return Result.BALL;
        }
        return Result.NOTHING;
    }

    public boolean isSameNumber(Ball ball) {
        return this.number.equals(ball.number);
    }

    public boolean isSamePosition(Ball ball) {
        return this.position.equals(ball.position);
    }

}
