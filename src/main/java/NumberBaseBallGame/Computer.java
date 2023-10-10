package NumberBaseBallGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Computer {

    public List<Integer> generateRandomNumbers() {
        List<Integer> numbers = new ArrayList<>();
        while(numbers.size() != 3) {
            int randomNumber = getRandomInt();
            if (numbers.contains(randomNumber)) continue;
            numbers.add(randomNumber);
        }
        return numbers;
    }

    private int getRandomInt() {
        Random random = new Random();
        return random.nextInt(9) + 1;
    }

    public Balls initializeBalls() {
        List<Integer> computerNumbers = generateRandomNumbers();
        return new Balls(computerNumbers);
    }
}
