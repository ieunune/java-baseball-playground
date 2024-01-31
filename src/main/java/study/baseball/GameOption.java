package study.baseball;

public enum GameOption {
    GAME_SIZE(3),
    THREE_STRIKE(3),
    RESTART(1),
    GAME_END(2);

    private final int option;

    GameOption(int option) {
        this.option = option;
    }
    public int getOption() {
        return this.option;
    }
}
