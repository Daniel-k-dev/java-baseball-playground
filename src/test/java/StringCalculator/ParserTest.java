package StringCalculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParserTest {
    @Test
    void parseCommand () {
        Parser parser = new Parser();
        String [] result = parser.parseCommand("2 + 3 * 4 / 2");
        assertThat(result).isEqualTo(new String[]{"2", "+", "3", "*", "4", "/", "2"});
    }
}
