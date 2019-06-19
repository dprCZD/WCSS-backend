package czd.wcssbackend.web;


import czd.wcssbackend.common.model.courseType.Course;
import czd.wcssbackend.common.model.courseType.PaidCourse;
import czd.wcssbackend.common.model.systemType.TrialReview;
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

    @Bean
    CourseService getCourseService(){return  new CourseServiceImpl();}

    @Bean
    CourseInfoService getCourseInfoService(){return new CourseInfoServiceImpl();}

    @Bean
    PaidCourseService getPaidCourseService(){return new PaidCourseServiceImpl();}

    @Bean
    TrialCourseService getTrialCourseService(){return new TrialCourseServiceImpl();}

    @Bean
    ShoppingListService getShoppingListService(){return new ShoppingListServiceImpl();}

    @Bean
    TrialReviewService getTrialReviewService(){return new TrialReviewServiceImpl();}

    @Bean
    NoticeService getNoticeService(){return  new NoticeServiceImpl();}

    @Bean
    NewsService getNewsService(){return  new NewsServiceImpl();}

}
