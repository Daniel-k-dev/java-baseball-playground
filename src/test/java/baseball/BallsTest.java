package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class BallsTest {
    Balls balls = new Balls("3,4,1");

    @Test
    void validBallTest() {
        assertThatThrownBy(() -> {
            new Balls("ad,4");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("숫자를 입력해야 합니다.");

        assertThatThrownBy(() -> {
            new Balls("3,4");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공의 개수가 3 이여야 합니다.");

        assertThatThrownBy(() -> {
            new Balls("3,4,3");
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage("공의 번호가 중복되었습니다.");

        assertDoesNotThrow(() -> {
            new Balls("3,2,9");
        });

    }

    @Test
    void playWithBallsTest() {
        Results results = new Results();
        results.plus(Result.STRIKE);
        results.plus(Result.NOTHING);
        results.plus(Result.BALL);

        assertThat(balls.play(new Balls("3,2,4"))).isEqualTo(results);
    }
}
