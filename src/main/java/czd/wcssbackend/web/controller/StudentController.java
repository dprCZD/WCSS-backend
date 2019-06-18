package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.userType.Student;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.controller.pojo.StudentCreateConfig;
import czd.wcssbackend.web.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName StudentController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:17
 */
@Api(value = "StudentController", description = "学生操作")
@RestController
@RequestMapping("/api/v1")
public class StudentController {

    private static final Logger logger = LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentService service;

    @ApiOperation(value = "获取学生stuid", notes = "获取学生", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "stuId", value = "stuId", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/getStudentByStuId/{stuId}", method = RequestMethod.GET,produces = "application/json")
    public Student getStudentByStuId(@PathVariable("stuId")String stuId){
        int id=-1;
        try{
            id=Integer.valueOf(stuId);
        } catch (NumberFormatException e)
        {

        }
        Student bean=null;
        if(id!=-1)
            bean=service.getStudentByStuId(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该账户信息！").getMessage()); ;
        }
        logger.info("get student success:"+stuId);
        return bean;
    }

    @ApiOperation(value = "获取学生userId", notes = "获取学生", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "userId", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/getStudentByUserId/{userId}", method = RequestMethod.GET,produces = "application/json")
    public List<Student> getStudentByUserId(@PathVariable("userId")String userId){
        int id=-1;
        try{
            id=Integer.valueOf(userId);
        } catch (NumberFormatException e)
        {

        }
        List<Student> bean=null;
        if(id!=-1)
            bean=service.getStudentByUserId(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该账户信息！").getMessage()); ;
        }
        logger.info("get student success:"+userId);
        return bean;
    }


    @ApiOperation(value = "获取学生列表", notes = "获取学生列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/student", method = RequestMethod.GET,produces = "application/json")
    public List<Student> listStudents(@RequestParam(value = "keyword", required = false,defaultValue = "")String keyword)
    {
        return service.listStudents();
    }

    @ApiOperation(value = "更新学生", notes = "更新学生", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "student", value = "student", dataType = "Student", paramType = "body"),
    })
    @RequestMapping(value = "/student", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateStudent(@RequestBody Student student)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.updateStudentByStuId(student);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.UPDATE_STUDENT_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error("update student failure:"+messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_STUDENT_SUCCESS_CODE);
        messageBox.setMessage("update STUDENT success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "插入学生", notes = "插入学生", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "config", dataType = "StudentCreateConfig", paramType = "body"),
    })
    @RequestMapping(value = "/student", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertStudent(@RequestBody StudentCreateConfig config)
    {
        Student student=createStudentByConfig(config);
        MessageBox messageBox=new MessageBox();
        try{
            service.insertStudent(student);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_STUDENT_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_STUDENT_SUCCESS_CODE);
        messageBox.setMessage("insert Student success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    private Student createStudentByConfig(StudentCreateConfig config)
    {
        Student student =new Student();
        student.setStuBornDate(config.getStuBornDate());
        student.setStuHighPrice(config.getStuHighPrice());
        student.setStuLocation(config.getStuLocation());
        student.setStuLowPrice(config.getStuLowPrice());
        student.setStuName(config.getStuName());
        student.setStuSelectCourse(config.getStuSelectCourse());
        student.setStuSex(config.getStuSex());
        student.setUserId(config.getUserId());
        return  student;
    }
}
