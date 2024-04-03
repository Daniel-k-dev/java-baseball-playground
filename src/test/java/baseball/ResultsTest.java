package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResultsTest {

    @Test
    void makeMessageTest() {
        Results gameResult = new Results();
        gameResult.plus(Result.BALL);
        gameResult.plus(Result.STRIKE);
        gameResult.plus(Result.STRIKE);

        assertThat(gameResult.makeMessage()).isEqualTo("1볼 2스트라이크");
    }

    @Test
    void isThreeStrikeTest() {
        Results results = new Results();
        results.plus(Result.STRIKE);
        results.plus(Result.STRIKE);

        assertThat(results.isThreeStrike()).isFalse();

        results.plus(Result.STRIKE);
        assertThat(results.isThreeStrike()).isTrue();
    }
}
