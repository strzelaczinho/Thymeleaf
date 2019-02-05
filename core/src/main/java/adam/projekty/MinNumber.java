package adam.projekty;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// wlasna adnotacja , typ adnotacji :)
@Target({ElementType.FIELD,ElementType.PARAMETER,ElementType.METHOD}) // adnotacja moze zostac dodana do pola , parametru lub methody
@Retention(RetentionPolicy.RUNTIME)
@Qualifier // spring adnotacja do uzywania z innymi
public @interface MinNumber {

}