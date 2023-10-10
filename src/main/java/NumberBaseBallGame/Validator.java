package NumberBaseBallGame;

import java.util.HashSet;
import java.util.Set;

public class Validator {

    public boolean isValid(String numbers) {
        return isLengthThree(numbers) && !isDuplicated(numbers) && isValidRangeNumber(numbers);
    }
    public boolean isLengthThree(String numbers) {
        return numbers.length() == 3;
    }

    public boolean isDuplicated(String numbers) {
        Set<Character> set = new HashSet<>();
        for (int index = 0; index < numbers.length(); index++) {
            char target = numbers.charAt(index);
            if (set.contains(target)) return true;
            set.add(target);
        }
        return false;
    }

    public boolean isValidRangeNumber(String numbers) {
        if (!isNumber(numbers) || !isNumbersOverZero(numbers)) return false;
        return true;
    }

    private boolean isNumber(String numbers) {
        try {
            Integer.parseInt(numbers);
            return true;
        }catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean isNumbersOverZero(String numbers) {
        for (int i = 0; i < numbers.length(); i++) {
            if (isZero(numbers.charAt(i))) return false;
        }
        return true;
    }

    private boolean isZero(char c) {
        return c == '0';
    }
}
