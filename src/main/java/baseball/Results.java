package baseball;

import java.util.Objects;

public class Results {
    private int strikeCount = 0;
    private int ballCount = 0;
    private int nothingCount = 0;

    public String makeMessage() {
        if (isThreeNothing()) {
            return "낫싱";
        } else if (isThreeStrike()) {
            return strikeCount+"스트라이크";
        } else if (isThreeBall()) {
            return ballCount+"볼";
        } else if (isNoBall()) {
            return strikeCount + "스트라이크";
        } else if (isNoStrike()) {
            return ballCount+"볼";
        }
        return ballCount+"볼 " + strikeCount + "스트라이크";
    }

    private boolean isNoStrike() {
        return strikeCount == 0;
    }

    private boolean isNoBall() {
        return ballCount == 0;
    }

    private boolean isThreeBall() {
        return ballCount == 3;
    }

    public boolean isThreeStrike() {
        return strikeCount == 3;
    }

    private boolean isThreeNothing() {
        return nothingCount == 3;
    }

    public void plus(Result result) {
        if (Result.isBall(result)) {
            ballCount = ballCount + 1;
            return;
        } else if (Result.isStrike(result)) {
            strikeCount = strikeCount + 1;
            return;
        }
        nothingCount = nothingCount + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Results results = (Results) o;
        return strikeCount == results.strikeCount && ballCount == results.ballCount && nothingCount == results.nothingCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(strikeCount, ballCount, nothingCount);
    }
}
