package NumberBaseBallGame;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class BallTest {

    private Ball ball = new Ball(0,1);

    @DisplayName("공의 번호를 가지고 오는 테스트")
    @ParameterizedTest
    @CsvSource({"7, false", "1, true", "4, false"})
    void getNumber(int compareNumber, boolean expect) {
        assertThat(ball.getNumber() == compareNumber).isEqualTo(expect);
    }

    @Test
    void getIndex() {
        assertThat(ball.getIndex()).isEqualTo(0);
    }

    @Test
    void equals() {
        assertThat(ball.equals(new Ball(0,1)));
    }

    @Test
    void play() {
        assertThat(ball.play(new Ball(0,1))).isEqualTo(BallStatus.STRIKE);
        assertThat(ball.play(new Ball(2,1))).isEqualTo(BallStatus.BALL);
        assertThat(ball.play(new Ball(0,9))).isEqualTo(BallStatus.NOTHING);
    }
}
