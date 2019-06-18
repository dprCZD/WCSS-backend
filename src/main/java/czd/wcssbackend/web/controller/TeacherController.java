package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.userType.Teacher;
import czd.wcssbackend.web.controller.pojo.MessageBox;

import czd.wcssbackend.web.controller.pojo.TeacherCreateConfig;

import czd.wcssbackend.web.service.TeacherService;
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
 * @ClassName TeacherController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:17
 */
@Api(value = "TeacherController", description = "教师操作")
@RestController
@RequestMapping("/api/v1")
public class TeacherController {

    private static final Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @Autowired
    TeacherService service;

    @ApiOperation(value = "获取教师teachid", notes = "获取教师", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teachId", value = "teachId", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/getTeacherByTeachId/{teachId}", method = RequestMethod.GET,produces = "application/json")
    public Teacher getTeacherByTeachId(@PathVariable("teachId")String teachId){
        int id=-1;
        try{
            id=Integer.valueOf(teachId);
        } catch (NumberFormatException e)
        {

        }
        Teacher bean=null;
        if(id!=-1)
            bean=service.getTeacherByTeachId(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该账户信息！").getMessage()); ;
        }
        logger.info("get Teacher success:"+teachId);
        return bean;
    }

    @ApiOperation(value = "获取教师userId", notes = "获取教师", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "userId", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/getTeacherByUserId/{userId}", method = RequestMethod.GET,produces = "application/json")
    public Teacher getTeacherByUserId(@PathVariable("userId")String userId){
        int id=-1;
        try{
            id=Integer.valueOf(userId);
        } catch (NumberFormatException e)
        {

        }
        Teacher bean=null;
        if(id!=-1)
            bean=service.getTeacherByUserId(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该账户信息！").getMessage()); ;
        }
        logger.info("get Teacher success:"+userId);
        return bean;
    }


    @ApiOperation(value = "获取教师列表", notes = "获取教师列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/teacher", method = RequestMethod.GET,produces = "application/json")
    public List<Teacher> listTeachers(@RequestParam(value = "keyword", required = false,defaultValue = "")String keyword)
    {
        return service.listTeachers();
    }

    @ApiOperation(value = "更新教师", notes = "更新教师", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "teacher", value = "teacher", dataType = "Teacher", paramType = "body"),
    })
    @RequestMapping(value = "/teacher", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateTeacher(@RequestBody Teacher teacher)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.updateTeacherByTeachId(teacher);
        }
        catch ( Exception e)
        {

            messageBox.setStatus(MessageBox.UPDATE_TEACHER_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error("update Teacher failure:"+messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_TEACHER_SUCCESS_CODE);
        messageBox.setMessage("update TEACHER success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "插入教师", notes = "插入教师", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "config", dataType = "TeacherCreateConfig", paramType = "body"),
    })
    @RequestMapping(value = "/teacher", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertTeacher(@RequestBody TeacherCreateConfig config)
    {
        Teacher teacher=createTeacherByConfig(config);
        MessageBox messageBox=new MessageBox();
        try{
            service.insertTeacher(teacher);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_TEACHER_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_TEACHER_SUCCESS_CODE);
        messageBox.setMessage("insert Teacher success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    private Teacher createTeacherByConfig(TeacherCreateConfig config)
    {
        Teacher teacher =new Teacher();
        teacher.setTeachFitAge(config.getTeachFitAge());
        teacher.setTeachGender(config.getTeachGender());
        teacher.setTeachIdNumber(config.getTeachIdNumber());
        teacher.setTeachIntroduction(config.getTeachIntroduction());
        teacher.setTeachName(config.getTeachName());
        teacher.setTeachSubject(config.getTeachSubject());
        teacher.setTeachTel(config.getTeachTel());
        teacher.setTeachYears(config.getTeachYears());
        teacher.setUserId(config.getUserId());
        return  teacher;
    }
}
