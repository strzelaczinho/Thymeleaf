package adam.projekty;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication //dodaje :)
public class Main{


    public static void main(String[] args) {


        //integruje spring boot z nasza klasa na koniec
        SpringApplication.run(Main.class,args);

    }
}
