package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringTest {
    @Test
    @DisplayName("split 메소드를 이용하며 문자열 배열을 가지고 오는 테스트")
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("split 메소드를 이용하며 문자열 배열을 가지고 오는 테스트")
    void split() {
        String [] result = "1,2".split(",");
        assertThat(result).contains("1","2");
    }

    @Test
    @DisplayName("substring 메소드를 이용하며 소괄호를 제거하는 테스트")
    void substring() {
        String target = "(1,2)";
        String removedRoundBrackets = target.substring(1, target.length()-1);
        assertThat(removedRoundBrackets).isEqualTo("1,2");
    }

    @Test
    @DisplayName("chatAt 메소드를 이용하며 문자를 가지고 올 때 문자열의 범위를 벗어났을 때 오류를 발생하는 테스트")
    void charAt () {
        assertThatThrownBy(() -> {
            String target = "abc";
            char targetChar = target.charAt(5);
        })
                .isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 5");
    }

}
