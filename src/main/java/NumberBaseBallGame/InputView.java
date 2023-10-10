package NumberBaseBallGame;

import java.util.Scanner;

public class InputView {
    Scanner sc = new Scanner(System.in);
    public void show() {
        System.out.print("숫자를 입력해 주세요 : ");
    }

    public String choiceRestart () {
        return sc.nextLine();
    }

    public String inputNumbers() {
        return sc.nextLine();
    }
}
