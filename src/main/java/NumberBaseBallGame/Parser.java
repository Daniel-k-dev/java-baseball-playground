package NumberBaseBallGame;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Integer> parseBallsNumber(String numbers) {
        List<Integer> parsedNumbers = new ArrayList<>();
        for (int index = 0; index < numbers.length(); index++) {
            String number = numbers.substring(index, index + 1);
            parsedNumbers.add(Integer.parseInt(number));
        }
        return parsedNumbers;
    }
}
