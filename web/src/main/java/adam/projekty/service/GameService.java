package adam.projekty.service;

public interface GameService {

    boolean isGameOver();
    String getMainMessage();
    String getResultMessage();
    void checkGuess(int quess);
    void reset();
}
