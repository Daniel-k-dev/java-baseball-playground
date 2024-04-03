package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SplitterTest {
    @Test
    void splitTest() {
        Splitter splitter = new Splitter();
        assertThat(splitter.split("1,2,3")).isEqualTo(new String[] {"1", "2", "3"});
    }
    
}
