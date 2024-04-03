package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class RandomTest {
    @Test
    void createNumberTest() {
        int random = new Random().createNumber();
        assertThat(random).isBetween(1, 9);
    }

    @Test
    void createDifferentNumbersTest() {
        List<Integer> randomNumbers = new Random().createDifferentNumbers();
        for (int randomNumber : randomNumbers) {
            assertThat(randomNumber).isBetween(1, 9);
        }
    }
}
