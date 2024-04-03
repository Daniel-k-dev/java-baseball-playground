package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {

    Ball ball = new Ball("3", 1);

    @Test
    void equalsTest() {
        assertThat(ball).isEqualTo(new Ball("3", 1));
        assertThat(ball).isNotEqualTo(new Ball("3", 0));
    }

    @Test
    void playTest() {
        assertThat(ball.play(new Ball("1",2))).isEqualTo(Result.NOTHING);
        assertThat(ball.play(new Ball("3",1))).isEqualTo(Result.STRIKE);
        assertThat(ball.play(new Ball("3",2))).isEqualTo(Result.BALL);
    }

    @Test
    void isSameNumberTest() {
        assertThat(ball.isSameNumber(new Ball("3",1))).isTrue();
        assertThat(ball.isSameNumber(new Ball("2",1))).isFalse();
    }

    @Test
    void isSamePositionTest() {
        assertThat(ball.isSamePosition(new Ball("3", 0))).isFalse();
        assertThat(ball.isSamePosition(new Ball("3", 1))).isTrue();
    }

}
