package adam.projekty.config;

import adam.projekty.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;


@PropertySource("classpath:config/game.properties")
@ComponentScan(basePackages="adam.projekty")
@Configuration
public class GameConfig
{
 @Value("${game.maxNumber}")
 private int maxNumber;
 @Value("${game.guessCount:10}") // defaultowo 10 jak nie znajdzie wartosci w pliku
 private int guessCount;
 @Value("${game.minNumber}")
 private int minNumber;


 @Bean
 @MaxNumber
 public int maxNumber() // dziala tak dlugo dopoki nazwa prymitywnej zmiennej int pasuje do nazwy tego beana ktory zostanie autowirowany i wstrzykniety jako zaleznosc
 {
     return maxNumber;
 }
 @Bean
 @GuessCount
 public int guessCount() // jesli zywam qualifiers z autowired w polu moge zmieniac nazwyw np z quessCount na quessCount2 i tak zadziala , nie zadzialoloby na samym autowirowaniu bez inrerface quessNumber wlasnej Adnotacji
 {
     return guessCount;
 }
 @Bean
 @MinNumber
    public int minNumber()
 {
     return minNumber;
 }

}
