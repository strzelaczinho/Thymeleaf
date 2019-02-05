package adam.projekty.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//ParameterizableViewController . ViewConrollerktory zostal zarejestrowany to tzw kontroller ktory zwraca preconfigured View. Byl skonfigurowany w WebConfig
@Slf4j
public class RequestInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.debug("preHandle method called. handler = {}",handler);
        log.debug("URL = {}",request.getRequestURL());
        return true;//false breaks execution of request . Nie odpali sie 8080
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("postHandle method called. handler = {}",handler);
        log.debug("URL = {}",request.getRequestURL());
        log.debug("model = {}",modelAndView.getModel());
        log.debug("view = {}",modelAndView.getViewName());
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.debug("afterCompletion method called. handler = {}",handler);
        log.debug("URL = {}",request.getRequestURL());
    }
}
