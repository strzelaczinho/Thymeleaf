package adam.projekty.util.thymeleaf;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.spring5.templateresolver.SpringResourceTemplateResolver;

import javax.annotation.PostConstruct;

//tak sie ustawia Decoupled Logic in Thymeleaf. ENABLES tzw plikow th.html

@Slf4j
@Component  //teraz mozemy Autowirowac beany
public class DecoupledLogicSetup {

    private final SpringResourceTemplateResolver templateResolver;


    public DecoupledLogicSetup(SpringResourceTemplateResolver templateResolver) {
        this.templateResolver = templateResolver;
    }
    //init
    @PostConstruct
    public void init()
    {
            templateResolver.setUseDecoupledLogic(true);
            log.info("Decoupled template logic enabled");
    }
}
