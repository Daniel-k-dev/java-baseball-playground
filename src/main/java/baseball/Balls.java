package baseball;

import java.util.LinkedList;
import java.util.List;

public class Balls {
    private final int ballSize = 3;
    private List<Ball> balls = new LinkedList<>();

    private Splitter splitter = new Splitter();

    public Balls(String input) {
        String[] stringNumbers = splitter.split(input);
        List<Ball> thoseBalls = createBalls(stringNumbers);

        checkValid(thoseBalls);
        this.balls = thoseBalls;
    }

    private List<Ball> createBalls(String[] stringNumbers) {
        List<Ball> thoseBalls = new LinkedList<>();

        for (int index = 0; index < stringNumbers.length; index++) {
            thoseBalls.add(new Ball(stringNumbers[index], index));
        }

        return thoseBalls;
    }

    private void checkValid(List<Ball> thoseBalls) {
        checkBallsSize(thoseBalls);
        checkInvalidBalls(thoseBalls);
    }

    private void checkInvalidBalls(List<Ball> thoseBalls) {
        List<Ball> validatedBalls = new LinkedList<>();
        for (Ball thatBall : thoseBalls) {
            checkInvalidBall(validatedBalls, thatBall);
            validatedBalls.add(thatBall);
        }
    }

    private void checkInvalidBall(List<Ball> validatedBalls, Ball thatBall) {
        for (Ball validatedBall : validatedBalls) {
            checkExistNumber(validatedBall, thatBall);
            checkExistPosition(validatedBall, thatBall);
        }
    }

    private void checkBallsSize(List<Ball> balls) {
        if (isInvalidBallSize(balls)) {
            throw new IllegalArgumentException("공의 개수가 3 이여야 합니다.");
        }
    }

    private boolean isInvalidBallSize(List<Ball> balls) {
        return balls.size() != ballSize;
    }

    private void checkExistPosition(Ball thatBall, Ball thisBall) {
        if (thisBall.isSamePosition(thatBall)) {
            throw new IllegalArgumentException("공의 위치가 중복되었습니다.");
        }
    }

    private void checkExistNumber(Ball thatBall, Ball thisBall) {
        if (thisBall.isSameNumber(thatBall)) {
            throw new IllegalArgumentException("공의 번호가 중복되었습니다.");
        }
    }

    public Results play(Balls comBalls) {
        Results results = new Results();
        for (Ball playerBall : this.balls) {
            results.plus(comBalls.play(playerBall));
        }
        return results;
    }

    private Result play(Ball comBall) {
        if (this.balls.contains(comBall)) {
            return Result.STRIKE;
        } else if (isBall(comBall)) {
            return Result.BALL;
        }
        return Result.NOTHING;
    }

    private boolean isBall(Ball comBall) {
        for (Ball playerBall : this.balls) {
            if (Result.isBall(playerBall.play(comBall))) {
                return true;
            }
        }
        return false;
    }
}
