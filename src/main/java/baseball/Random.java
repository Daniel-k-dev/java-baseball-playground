package baseball;

import java.util.LinkedList;
import java.util.List;

public class Random {
    public int createNumber() {
        return (int) (Math.random() * 9) + 1;
    }

    public List<Integer> createDifferentNumbers() {
        List<Integer> randomNumbers = new LinkedList<>();
        while (randomNumbers.size() != 3) {
            int randomNumber = createNumber();
            contain(randomNumbers, randomNumber);
        }
        return randomNumbers;
    }

    private void contain(List<Integer> randomNumbers, int randomNumber) {
        if (!randomNumbers.contains(randomNumber)) {
            randomNumbers.add(randomNumber);
        }
    }

}
