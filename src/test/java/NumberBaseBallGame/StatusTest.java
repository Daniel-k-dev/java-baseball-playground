package NumberBaseBallGame;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

import static org.assertj.core.api.Assertions.assertThat;

public class StatusTest {

    private Ball ball = new Ball(0,1);

    private Balls balls = new Balls(new LinkedList(Arrays.asList(1,2,3)));

    @Test
    void isStrike() {
         assertThat(BallStatus.isStrike(ball, new Ball(0,1))).isEqualTo(true);
    }

    @Test
    void isBall() {
        assertThat(BallStatus.isBall(ball, new Ball(2,1))).isEqualTo(true);
    }

}
