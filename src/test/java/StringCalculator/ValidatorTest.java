package StringCalculator;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    @DisplayName("문자열 정수")
    @ParameterizedTest
    @CsvSource(value = {"3,true", "2523,true", "-,false"})
    void checkNumber (String number, boolean expect) {
        Validator validator = new Validator();
        boolean result1 = validator.isNumber(number);
        assertThat(result1).isEqualTo(expect);
    }

    @DisplayName("문자열 정수")
    @ParameterizedTest
    @CsvSource(value = {"+:true", "-:true", "/:true", "*:true", "A:false", "1:false", "129y8:false"}, delimiter = ':')
    void checkOperator (String operator, boolean expect) {
        Validator validator = new Validator();
        boolean result1 = validator.isOperator(operator);
        assertThat(result1).isEqualTo(expect);
    }


    @ParameterizedTest
    @CsvSource(value = {"1 + 2:true", "a + 1:false", "a a a:false", "- - -:false", "2 + 3 * 4 / 2:true", "2 + 3 * 4 /:false"}, delimiter = ':')
    void checkCommand (String command, boolean expect) {
        Validator validator = new Validator();
        boolean result = validator.checkCommands(command);
        assertThat(result).isEqualTo(expect);
    }

}
