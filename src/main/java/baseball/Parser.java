package baseball;

import java.util.List;

public class Parser {
    public String parseToString(List<Integer> numbers) {
        return numbers.toString()
                .replace("[", "")
                .replace("]", "")
                .replace(" ", "");
    }
}
