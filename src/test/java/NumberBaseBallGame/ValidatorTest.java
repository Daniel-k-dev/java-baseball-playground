package NumberBaseBallGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    private Validator validator = new Validator();

    @DisplayName("길이가 3인지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource({"123, true", "12A, false", "1234, false", "120, false"})
    void isValid(String numbers, boolean expect) {
        assertThat(validator.isValid(numbers)).isEqualTo(expect);
    }


    @DisplayName("길이가 3인지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource({"123, true", "12, false", "1234, false"})
    void isLengthThree(String numbers, boolean expect) {
        assertThat(validator.isLengthThree(numbers)).isEqualTo(expect);
    }

    @DisplayName("1부터 9까지의 숫자인지 확인하는 테스트")
    @ParameterizedTest
    @CsvSource({"123, true", "12A, false", "12=, false", "120, false"})
    void isValidNumber(String numbers, boolean expect) {
        assertThat(validator.isValidRangeNumber(numbers)).isEqualTo(expect);
    }

    @DisplayName("숫자의 중복을 확인하는 테스트")
    @ParameterizedTest
    @CsvSource({"123, false", "121, true", "122, true", "333, true"})
    void isDuplicated(String numbers, boolean expect) {
        assertThat(validator.isDuplicated(numbers)).isEqualTo(expect);
    }
}
