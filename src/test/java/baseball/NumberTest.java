package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class NumberTest {
    @Test
    void validTest() {
        assertThatThrownBy(() -> {
            new Number("0");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공의 숫자는 1 부터 9 이내여야 합니다.");

        assertThatThrownBy(() -> {
            new Number("10");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공의 숫자는 1 부터 9 이내여야 합니다.");

        assertDoesNotThrow(() -> {
            new Number("1");
            new Number("9");
        });
    }
}
