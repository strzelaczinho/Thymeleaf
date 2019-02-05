package adam.projekty.console;
import adam.projekty.Game;
import adam.projekty.MessageGenerator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import java.util.Scanner;

//Przyklad nasluchiawania eventow
@Component
@Slf4j
public class ConsoleNumberGuess  {
    private final Game game;
    private final MessageGenerator messageGenerator;
    public ConsoleNumberGuess(Game game, MessageGenerator messageGenerator)
    {
        this.game = game;
        this.messageGenerator = messageGenerator;
    }
    @EventListener(ContextRefreshedEvent.class)
    public void start() {
        log.info("start() --> Container ready for use  ");
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println(messageGenerator.getMainMessage());
            System.out.println(messageGenerator.getResultMessage());
            int quess = scanner.nextInt();
            scanner.nextLine();
            game.setGuess(quess);
            game.check();
            if (game.isGameWon() || game.isGameLost())
            {
                System.out.println(messageGenerator.getResultMessage());
                System.out.println("Play again y/n?");

                String playAgainString = scanner.nextLine().trim();
                if (!playAgainString.equalsIgnoreCase("y"))
                {
                    break;
                }
                game.reset();
            }
        }
    }
}
/*
Na dole Przyklad nasluchiawania eventow metoda a u gory przyklad nasluchiwania eventow adnotacja i byle jaka nazwa metody
@Component
public class ConsoleNumberGuess implements ApplicationListener<ContextRefreshedEvent> {
    private static final Logger log = LoggerFactory.getLogger(ConsoleNumberGuess.class);

    // wola sie kiedy application contexxt jest inicjalizowana . Wtedy kiedy wola sie wszystkie beany / singletony obiekty
    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.info("Container ready for use ");
    }
}
*/