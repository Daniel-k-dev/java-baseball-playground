package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class PositionTest {
    @Test
    void validTest() {
        assertThatThrownBy(() -> {
            new Position(3);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자리는 1 ~ 3 이여야 입니다.");

        assertThatThrownBy(() -> {
            new Position(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("자리는 1 ~ 3 이여야 입니다.");

        assertDoesNotThrow(() -> {
            new Position(0);
            new Position(2);
        });
    }

}
