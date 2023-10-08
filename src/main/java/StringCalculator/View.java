package StringCalculator;

import java.util.Scanner;

public class View {
    public String  showInputView () {
        System.out.println("수식 입력 : ");
        Scanner sc = new Scanner(System.in);
        String operation = sc.nextLine();
        return operation;
    }

    public void showErrorView () {
        System.out.println("부적절한 연산");
    }

    public void showOutpuptView (int result) {
        System.out.println("결과물 : " + result);
    }
}
