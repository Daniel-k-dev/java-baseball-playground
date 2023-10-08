package StringCalculator;

public class Calculator {
    public int calculate(String [] command) {
        int result = Integer.parseInt(command[0]);
        for (int index = 1; index < command.length; index = index + 2) {
            result = calculate(command, result, index);
        }
        return result;
    }

    private int calculate(String[] command, int result, int index) {
        if (command[index].equals("+")) {
            result += Integer.parseInt(command[index + 1]);
        }
        else if (command[index].equals("-")) {
            result -= Integer.parseInt(command[index + 1]);
        }
        else if (command[index].equals("*")) {
            result *= Integer.parseInt(command[index + 1]);
        }
        else if (command[index].equals("/")) {
            result /= Integer.parseInt(command[index + 1]);
        }
        return result;
    }
}
