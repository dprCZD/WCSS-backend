package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.courseType.Course;
import czd.wcssbackend.web.controller.pojo.CourseCreateConfig;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.service.CourseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

/**
 * @ClassName CourseController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/16 21:10
 */
@Api(value = "CourseController", description = "课程操作")
@RestController
@RequestMapping("/api/v1")
public class CourseController {

    private static final Logger logger = LoggerFactory.getLogger(CourseController.class);

    @Autowired
    CourseService service;

    @ApiOperation(value = "获取课程", notes = "获取课程", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "courseId", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/course/{courseId}", method = RequestMethod.GET,produces = "application/json")
    public Course getCourse(@PathVariable("courseId")String courseId){
        int id=-1;
        try{
            id=Integer.valueOf(courseId);
        } catch (NumberFormatException e)
        {

        }
        Course bean=null;
        if(id!=-1)
            bean=service.getCourse(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该课程信息！").getMessage()); ;
        }
        logger.info("get parent success:"+courseId);
        return bean;
    }




    @ApiOperation(value = "获取课程列表", notes = "获取课程列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/course", method = RequestMethod.GET,produces = "application/json")
    public List<Course> listCourses(@RequestParam(value = "keyword", required = false,defaultValue = "")String keyword)
    {
        return service.listCourses();
    }

    @ApiOperation(value = "更新课程", notes = "课程", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "course", value = "course", dataType = "Course", paramType = "body"),
    })
    @RequestMapping(value = "/course", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateCourse(@RequestBody Course course)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.updateCourse(course);
        }
        catch ( Exception e)
        {
            logger.error("update COURSE failure:"+messageBox.getMessage());
            messageBox.setStatus(MessageBox.UPDATE_COURSE_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_COURSE_SUCCESS_CODE);
        messageBox.setMessage("update COURSE success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "插入课程", notes = "插入课程", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "config", dataType = "CourseCreateConfig", paramType = "body"),
    })
    @RequestMapping(value = "/course", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertParent(@RequestBody CourseCreateConfig config)
    {
        Course course=createCourseByConfig(config);
        MessageBox messageBox=new MessageBox();
        try{
            service.insertCourse(course);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_COURSE_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_COURSE_SUCCESS_CODE);
        messageBox.setMessage("insert COURSE success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    private Course createCourseByConfig(CourseCreateConfig config)
    {
        Course course=new Course();
        course.setTeacherName(config.getTeacherName());
        course.setCourseDirection(config.getCourseLocation());
        course.setCourseFitAge(config.getCourseFitAge());
        course.setCourseLocation(config.getCourseLocation());
        course.setCourseName(config.getCourseName());
        course.setCoursePrice(config.getCoursePrice());
        course.setCourseTime(config.getCourseTime());
        course.setCourseUserStars(config.getCourseUserStars());
        course.setTeacherId(config.getTeacherId());
        return  course;
    }
}
