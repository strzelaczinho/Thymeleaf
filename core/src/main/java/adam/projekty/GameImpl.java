package adam.projekty;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Getter
@Component
public class GameImpl implements Game {

    @Getter(AccessLevel.NONE) // nie wygeneruje getter dla NumbeerGenerator
    private final NumberGenerator numberGenerator;

    private final int guessCount;

    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount)
    {
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    private int number;


    private int smallest;
    private int biggest;
    private int remainingGuesses;
    private boolean validNumberRange = true;

    @Setter
    private int guess;

    // == tutaj domyslny konstruktor metody korzystajcy z <bean class="org.springframework.context.annotation.CommonAnnotationBeanPostProcessor"/>
    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = numberGenerator.getMinNumber();
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}", number);
    }
    @PreDestroy
    public void preDestroy()
    {
        log.info("in Game preDestroy");
    }

    //setter based
//    public void setUstawNumberGenerator(NumberGenerator numberGenerator)
//    {
//        this.numberGenerator = numberGenerator;
//    }
   //  konstruktor based
//    public GameImpl(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator; // zeby nulla nie wwwyrzucalo
//    }

    @Override
    public void check() {

        checkValidNumberRange();

        if(validNumberRange) {
            if(guess > number) {
                biggest = guess -1;
            }

            if(guess < number) {
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }

    // == private methods ==
    private void checkValidNumberRange() {
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
