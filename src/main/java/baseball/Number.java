package baseball;

import java.util.Objects;

public class Number {

    private final int number;

    public Number(String number) {
        checkValid(number);
        this.number = Integer.parseInt(number);
    }

    private void checkValid(String stringNumber) {
        checkNumber(stringNumber);
        checkAvailableRangeNumber(stringNumber);
    }

    private void checkAvailableRangeNumber(String stringNumber) {
        int number = Integer.parseInt(stringNumber);
        if (isAvailableRangeNumber(number) == false) {
            throw new IllegalArgumentException("공의 숫자는 1 부터 9 이내여야 합니다.");
        }
    }

    private void checkNumber(String stringNumber) {
        if (doesCanParseToInt(stringNumber) == false) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    private boolean doesCanParseToInt(String stringNumber) {
        try {
            Integer.parseInt(stringNumber);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isAvailableRangeNumber(int ballNumber) {
        return isOverZero(ballNumber) && isUnderTen(ballNumber);
    }

    private boolean isOverZero(int ballNumber) {
        return 0 < ballNumber;
    }

    private boolean isUnderTen(int ballNumber) {
        return ballNumber < 10;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Number that = (Number) o;
        return number == that.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }
}
