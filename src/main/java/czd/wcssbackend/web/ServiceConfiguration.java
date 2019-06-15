package czd.wcssbackend.web;


import czd.wcssbackend.web.impl.*;
import czd.wcssbackend.web.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfiguration {

    @Bean
    UserService getUserService()
    {
        return new UserServiceImpl();
    }

    @Bean
    ParentService getParentService(){return new ParentServiceImpl(); }
    @Bean
    StudentService getStudentService(){return new StudentServiceImpl(); }
    @Bean
    TeacherService getTeacherService(){return new TeacherServiceImpl(); }
    @Bean
    EduInsService getEduInsService(){return new EduInsServiceImpl(); }

}
