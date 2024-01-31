package study.baseball;

import java.util.Scanner;

public class Player {

    private String playerNumbers;

    public Player() {

    }

    public void InputPlayerNumber() {

        Scanner input = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        String InputPlayerNumbers = input.next();

        this.playerNumbers = InputPlayerNumbers;
    }

    public String getPlayerNumbers() {
        return this.playerNumbers;
    }
}
