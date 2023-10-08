package StringCalculator;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Parser parser = new Parser();
        Validator validator = new Validator();
        View view = new View();

        String command = view.showInputView();
        boolean validateResult = validator.checkCommands(command);
        if (validateResult) {
            String [] parsedCommand = parser.parseCommand(command);
            int result = calculator.calculate(parsedCommand);
            view.showOutpuptView(result);
        }
        else {
            view.showErrorView();
        }
    }
}
