package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class InputValidateTest {

    @Test
    void checkTest() {
        assertThatThrownBy(() -> {
            new GameOverInputValidator().check("");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1 또는 2를 입력해야 합니다.");

        assertDoesNotThrow(() -> {
            new GameOverInputValidator().check("1");
            new GameOverInputValidator().check("2");
        });
    }
}
