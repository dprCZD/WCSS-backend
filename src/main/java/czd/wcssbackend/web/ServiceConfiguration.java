package czd.wcssbackend.web;


import czd.wcssbackend.web.impl.UserServiceImpl;
import czd.wcssbackend.web.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    UserService getUserService()
    {
        return new UserServiceImpl();
    }

}
