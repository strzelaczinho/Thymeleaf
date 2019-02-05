package adam.projekty.config;
import adam.projekty.interceptor.RequestInterceptor;
import adam.projekty.util.ViewNames;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName(ViewNames.HOME); // mapuje mejn na /
 //       registry.addViewController("home").setViewName(ViewNames.HOME); // mapuje mejn na home ...
    }
    //pomaga w post i preprocessing invoke methods w controlerze. Musimy zarejestrowac
    @Override
    public void addInterceptors(InterceptorRegistry registry) {//pomaga w konfiguracji listy map interceptorow pomocnych przy zmianie jezyka
        registry.addInterceptor(new RequestInterceptor());


        //tutaj rejestruje locale change interceptor ale moge dac new odrazu bez parametrow :)
     //   LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
     //   localeChangeInterceptor.setParamName("lang"); //http://localhost:8080/?lang=es czyli param name:)     //http://localhost:8080/?lang=eng

        //registry.addInterceptor(localeChangeInterceptor);
          registry.addInterceptor(new LocaleChangeInterceptor());


          //bez ParamName wpisuje http://localhost:8080/?locale=es lub http://localhost:8080 i domyslnie angol bedzie
    }


    //tutaj rejestruje bean ktory bedzie odpowiadal za zamiane jezyka , podczas Sesji uzytkownika(mozna jeszcze cookeis i jeszcze jakos)
    @Bean
    public LocaleResolver localeResolver()
    {
        return new SessionLocaleResolver();
    }
}
