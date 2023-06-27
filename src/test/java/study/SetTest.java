package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현
    @Test
    @DisplayName("HashSet의 size 메소드를 이용하여 HashSet의 길이를 가지고 오는 테스트")
    void size () {
        int sizeOfHashSet = numbers.size();
        assertThat(sizeOfHashSet).isEqualTo(3);
    }

    @ParameterizedTest
    @CsvSource({"1,true", "2,true", "3,true", "4,false", "5,false"})
    @DisplayName("HashSet의 contain 메소드를 이용하여 특정 값이 존재하는지 확인하는 테스트")
    void contains (String input, String expect) {
        int parsedInput = Integer.parseInt(input);
        boolean parsedExpect = Boolean.parseBoolean(expect);

        assertEquals(parsedExpect, numbers.contains(parsedInput));
    }

}