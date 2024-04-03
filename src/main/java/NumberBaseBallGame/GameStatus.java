package NumberBaseBallGame;

public enum GameStatus {
    END,
    PLAY;

    public static boolean isEnd(GameStatus gameStatus) {
        return gameStatus == END;
    }

    public static boolean isPlay(GameStatus gameStatus) {
        return gameStatus == PLAY;
    }
}
