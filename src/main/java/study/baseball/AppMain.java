package study.baseball;

import java.util.Scanner;

public class AppMain {

    public static void main(String[] args) {

        // init
        int game_size = 3;

        // input playerNumbers
        Scanner input = new Scanner(System.in);
        System.out.print("숫자를 입력해 주세요 : ");
        String playerNumbers = input.next();

        // validation
        validation(playerNumbers);

        if (playerNumbers.length() > 3) {
            System.out.println("이번 게임의 자릿수 는 " + game_size + " 입니다.");
        }

        // Auto set numbers For Computer
        String computerNumbers = new Computer(game_size).generateNumber();

        // Log
        System.out.println("playerNumbers = " + playerNumbers + ", computerNumbers = " + computerNumbers);

        // play games
        int strike = 0;
        int ball = 0;
        int[] player = getStringToIntArray(playerNumbers);
        int[] computer = getStringToIntArray(computerNumbers);

        for (int i = 0 ; i < game_size; ++i) {
            if (player[i] == computer[i]) {
                strike++;
            }
            for (int j = 0; j < computer.length; j++) {
                if (player[i] == computer[j] && i != j) {
                    ball++;
                    break;
                }
            }
        }

        if (strike == 3) {
            System.out.println("3스트라이크");
        }

    }

    private static void validation(String playerNumbers) {
        for (char c : playerNumbers.toCharArray()) {
            isNumber(c);
            if (c == '0') {
                System.out.println("0 값은 입력할 수 없습니다.");;
            }
        }
    }

    private static boolean isNumber(char c) {
        boolean isNumber = true;
        if (!Character.isDigit(c)) {
            System.out.println("입력한 값은 숫자가 아닙니다.");;
            isNumber = false;
        }

        return isNumber;
    }

    public static int[] getStringToIntArray(String str) {
        char[] charArray = str.toCharArray();
        int[] intArray = new int[charArray.length];
        for (int i = 0; i < charArray.length; i++) {
            intArray[i] = charArray[i] - '0';
        }

        return intArray;
    }
}
/**
 * 기능 요구 사항
 * 기본적으로 1부터 9까지 서로 다른 수로 이루어진 3자리의 수를 맞추는 게임이다.
 *
 * 같은 수가 같은 자리에 있으면 스트라이크, 다른 자리에 있으면 볼, 같은 수가 전혀 없으면 포볼 또는 낫싱이란 힌트를 얻고, 그 힌트를 이용해서 먼저 상대방(컴퓨터)의 수를 맞추면 승리한다.
 * e.g. 상대방(컴퓨터)의 수가 425일 때, 123을 제시한 경우 : 1스트라이크, 456을 제시한 경우 : 1볼 1스트라이크, 789를 제시한 경우 : 낫싱
 * 위 숫자 야구 게임에서 상대방의 역할을 컴퓨터가 한다. 컴퓨터는 1에서 9까지 서로 다른 임의의 수 3개를 선택한다. 게 임 플레이어는 컴퓨터가 생각하고 있는 3개의 숫자를 입력하고, 컴퓨터는 입력한 숫자에 대한 결과를 출력한다.
 * 이 같은 과정을 반복해 컴퓨터가 선택한 3개의 숫자를 모두 맞히면 게임이 종료된다.
 * 게임을 종료한 후 게임을 다시 시작하거나 완전히 종료할 수 있다.
 */