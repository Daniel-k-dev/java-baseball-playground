package baseball;

import java.util.Objects;

public class Position {

    private final int position;
    public Position(int position) {
        checkValid(position);
        this.position = position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    private void checkValid(int position) {
        if (isValidArrange(position) == false) {
            throw new IllegalArgumentException("자리는 1 ~ 3 이여야 입니다.");
        }
    }

    private boolean isValidArrange(int position) {
        return 0 <= position && position < 3;
    }
}
