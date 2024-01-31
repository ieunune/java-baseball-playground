package study.baseball;

public class Game {

    private final Player player;
    private final Computer computer;

    public Game(Player player, Computer computer) {
        this.player = player;
        this.computer = computer;
    }

    public void start() {

        while (true) {

            // input playerNumbers
            player.InputPlayerNumber();

            // validation
            validation(player.getPlayerNumbers(), GameOption.GAME_SIZE.getOption());

            // Log
            System.out.println("playerNumbers = " + player.getPlayerNumbers() + ", computerNumbers = " + computer.getComputerNumbers());

            // play games
            GameResult gameResult = new GameResult();
            gameResult.compare(player.getPlayerNumbers(), computer.getComputerNumbers());

            if (gameResult.isGameEnd()) {
                boolean isContinue = gameResult.isContinue();

                if (isContinue) {
                    new Computer();
                } else {
                    break;
                }
            }

        }
    }



    private static void validation(String playerNumbers, Integer gameSize) {

        // 자릿수 검증
        if (playerNumbers.length() > gameSize) {
            System.out.println("게임의 자릿수 는 " + gameSize + " 입니다. 자릿수를 맞춰 입력해주세요.");
        }

        // 입력 값
//        for (char c : playerNumbers.toCharArray()) {
//            if (isNumber(c) || c == '0') {
//                System.out.println("0 값은 입력할 수 없습니다.");
//            }
//        }
    }

    private static boolean isNumber(char c) {
        if (!Character.isDigit(c)) {
            System.out.println("입력한 값은 숫자가 아닙니다.");
            return false;
        }
        return true;
    }




}
