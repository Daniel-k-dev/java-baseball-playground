package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ResultTest {

    @Test
    void isBallTest() {
        assertThat(Result.isBall(Result.BALL)).isTrue();
        assertThat(Result.isBall(Result.STRIKE)).isFalse();
    }
}
