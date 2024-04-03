package baseball;

public class GameOverInputValidator {

    public void check(String input) {
        if (isInvalid(input)) {
            throw new IllegalArgumentException("1 또는 2를 입력해야 합니다.");
        }
    }

    private boolean isInvalid(String input) {
        return !isValid(input);
    }
    private boolean isValid(String input) {
        return input.equals("1") || input.equals("2");
    }

}
