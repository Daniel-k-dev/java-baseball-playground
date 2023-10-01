package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }


    @DisplayName("요구사항 1")
    @Test
    void split() {
        String [] result1 = "1,2".split(",");
        assertThat(result1).containsExactly("1", "2");
        String [] result2 = "1".split(",");
        assertThat(result2).containsExactly("1");
    }
}