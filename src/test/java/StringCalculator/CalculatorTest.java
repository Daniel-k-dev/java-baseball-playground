package StringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {
    @Test
    void calculate () {
        Calculator calculator = new Calculator();
        int result = calculator.calculate(new String[]{"2", "+", "3", "*", "4", "/", "2"});
        assertThat(result).isEqualTo(10);
    }
}
