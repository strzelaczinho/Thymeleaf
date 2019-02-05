package adam.projekty.service;

import adam.projekty.Game;
import adam.projekty.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
public class GameServiceImpl implements GameService {

    private final Game game;
    private final MessageGenerator messageGenerator;

    @Autowired
    public GameServiceImpl(Game game, MessageGenerator messageGenerator) {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }

    // metoda init
    @PostConstruct
    public void init()
    {
        log.info("number = {}",game.getNumber());
        log.info("mainMessage = {}",messageGenerator.getMainMessage());
    }
    @Override
    public boolean isGameOver() {
        return game.isGameWon() || game.isGameLost();
    }
    @Override
    public String getMainMessage() {
        return messageGenerator.getMainMessage();
    }
    @Override
    public String getResultMessage() {
        return messageGenerator.getResultMessage();
    }
    @Override
    public void checkGuess(int quess) {
        game.setGuess(quess);
        game.check();
    }
    @Override
    public void reset() {
        game.reset();
    }
}
