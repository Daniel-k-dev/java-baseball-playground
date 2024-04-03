package baseball;

public enum Result {
    STRIKE, BALL, NOTHING;

    public static boolean isBall(Result result) {
        return result == BALL;
    }

    public static boolean isStrike(Result result) {
        return result == STRIKE;
    }

}
