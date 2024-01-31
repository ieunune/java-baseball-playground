package study.baseball;

import java.util.Scanner;

public class Game {

    private final Player player;
    private final Computer computer;

    public Game(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void start() {

        // Auto set numbers For Computer
        String computerNumbers = computer.getComputerNumbers();

        while (true) {

            // input playerNumbers
            player.InputPlayerNumber();

            // validation
            validation(player.getPlayerNumbers(), GameOption.GAME_SIZE.getOption());

            // Log
            // System.out.println("playerNumbers = " + playerNumbers + ", computerNumbers = " + computerNumbers);

            // play games
            int strike = 0;
            int ball = 0;
            int[] playerNumber = getStringToIntArray(player.getPlayerNumbers());
            int[] computerNumber = getStringToIntArray(computerNumbers);

            GameResult result = getGameResult(strike, ball, playerNumber, computerNumber);

            if (result.strike == GameOption.THREE_STRIKE.getOption()) {
                System.out.println("3스트라이크");
                System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
                System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
                Scanner input = new Scanner(System.in);
                System.out.print("입력 : ");
                int inputValue = input.nextInt();
                if (inputValue == GameOption.RESTART.getOption()) {
                    computerNumbers = new Computer(GameOption.GAME_SIZE.getOption()).generateNumber();
                }

                if (inputValue == GameOption.GAME_END.getOption()) {
                    break;
                }
            }

            System.out.printf("%s 스트라이크 %s 볼 %n", result.strike, result.ball);

            if (result.strike == 0 & result.ball == 0) {
                System.out.println("낫싱");
            }
        }
    }

    private static GameResult getGameResult(int strike, int ball, int[] playerNumber, int[] computerNumber) {
        for (int i = 0; i < GameOption.GAME_SIZE.getOption(); ++i) {
            if (playerNumber[i] == computerNumber[i]) {
                strike++;
            }
            ball = checkBall(ball, playerNumber, computerNumber, i);
        }
        return new GameResult(strike, ball);
    }

    private static int checkBall(int ball, int[] playerNumber, int[] computerNumber, int i) {
        for (int j = 0; j < computerNumber.length; j++) {
            if (playerNumber[i] == computerNumber[j] && i != j) {
                ball++;
                break;
            }
        }
        return ball;
    }

    private static void validation(String playerNumbers, Integer gameSize) {

        // 자릿수 검증
        if (playerNumbers.length() > gameSize) {
            System.out.println("게임의 자릿수 는 " + gameSize + " 입니다. 자릿수를 맞춰 입력해주세요.");
        }

        // 입력 값
        for (char c : playerNumbers.toCharArray()) {
            if (isNumber(c) || c == '0') {
                System.out.println("0 값은 입력할 수 없습니다.");
            }
        }
    }

    private static boolean isNumber(char c) {
        if (!Character.isDigit(c)) {
            System.out.println("입력한 값은 숫자가 아닙니다.");
            return false;
        }
        return true;
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
