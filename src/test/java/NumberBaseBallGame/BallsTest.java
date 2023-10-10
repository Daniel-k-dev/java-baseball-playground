package NumberBaseBallGame;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BallsTest {
    private Balls balls = new Balls(new LinkedList<Integer> (Arrays.asList(1,2,3)));

    @Test
    void playBalls() {
        List<BallStatus> gameResult;
        Balls testBalls = new Balls(new LinkedList<Integer> (Arrays.asList(4,2,1)));
        gameResult = balls.play(testBalls);
        assertThat(gameResult).isEqualTo(new LinkedList<BallStatus>(Arrays.asList(BallStatus.NOTHING, BallStatus.STRIKE, BallStatus.BALL)));
    }

    @Test
    void twoBallOneStrike() {
        Balls testBalls = new Balls(new LinkedList<Integer> (Arrays.asList(8,9,1)));
        Balls balls1 = new Balls(new LinkedList<Integer> (Arrays.asList(9,8,1)));
        List<BallStatus> gameResult = balls1.play(testBalls);
        assertThat(gameResult).isEqualTo(new LinkedList<BallStatus>(Arrays.asList(BallStatus.BALL, BallStatus.BALL, BallStatus.STRIKE)));
        assertThat(gameResult).isNotEqualTo(new LinkedList<BallStatus>(Arrays.asList(BallStatus.NOTHING, BallStatus.NOTHING, BallStatus.STRIKE)));
    }

    @Test
    void threeStrike() {
        List<BallStatus> gameResult = balls.play(balls);
        assertThat(gameResult).isEqualTo(new LinkedList<BallStatus>(Arrays.asList(BallStatus.STRIKE, BallStatus.STRIKE, BallStatus.STRIKE)));
        assertThat(gameResult).isNotEqualTo(new LinkedList<BallStatus>(Arrays.asList(BallStatus.BALL, BallStatus.STRIKE, BallStatus.STRIKE)));
    }

    @Test
    void playBall() {
        assertThat(balls.play(new Ball(0,1))).isEqualTo(BallStatus.STRIKE);
        assertThat(balls.play(new Ball(1,1))).isEqualTo(BallStatus.BALL);
        assertThat(balls.play(new Ball(1,6))).isEqualTo(BallStatus.NOTHING);
    }
}
