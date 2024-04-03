package StringCalculator;

public class Validator {

    public boolean isNumber(String number) {
        try {
            Integer.parseInt(number);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean isOperator(String operator) {
        String [] operators = {"+", "-", "*", "/"};
        for (String unit :operators) {
            if (isOperator(operator, unit)) return true;
        }
        return false;
    }

    private boolean isOperator(String operator, String unit) {
        if (operator.equals(unit)) {
            return true;
        }
        return false;
    }

    public boolean checkCommands(String command) {
        String [] splitedCommand = command.split(" ");
        String lastElement = splitedCommand[splitedCommand.length - 1];
        if (isLastElementIsOperator(lastElement)) return false;
        for (int index = 0; index < splitedCommand.length; index++) {
            if (checkCommand(splitedCommand, index)) return false;
            continue;
        }
        return true;
    }

    private boolean isLastElementIsOperator(String lastElement) {
        if (isOperator(lastElement)) {
            return true;
        }
        return false;
    }

    private boolean checkCommand(String[] splitedCommand, int index) {
        if (index % 2 == 0) {
            if (isNumber(splitedCommand, index)) return true;
        }
        else if (!isOperator(splitedCommand[index])) {
            return true;
        }
        return false;
    }

    private boolean isNumber(String[] splitedCommand, int index) {
        if (!isNumber(splitedCommand[index])) {
            return true;
        }
        return false;
    }
}
