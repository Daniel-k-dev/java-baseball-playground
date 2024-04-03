package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ParserTest {
    @Test
    void parseToString() {
        String stringfiedNumbers = new Parser().parseToString(Arrays.asList(1,2,3));

        assertThat(stringfiedNumbers).isEqualTo("1,2,3");
    }
}
