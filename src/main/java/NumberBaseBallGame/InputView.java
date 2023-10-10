package NumberBaseBallGame;

import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);
    public void show() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public String inputNumber() {
        return sc.nextLine();
    }

    public int choiceRestart () {
        int choice = sc.nextInt();
        sc.nextLine();
        return choice;
    }
}
