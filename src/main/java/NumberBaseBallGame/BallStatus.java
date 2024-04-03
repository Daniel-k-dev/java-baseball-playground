package NumberBaseBallGame;

public enum BallStatus {
    STRIKE,
    BALL,
    NOTHING;

    public static boolean isStrike(Ball userBall, Ball comBall) {
        return userBall.equals(comBall);
    }

    public static boolean isBall(Ball userBall, Ball comBall) {
        return userBall.isEqualsNumber(comBall) && userBall.getIndex() != comBall.getIndex();
    }
}
