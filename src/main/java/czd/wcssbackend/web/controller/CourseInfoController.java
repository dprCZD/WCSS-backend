package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.courseType.Course;
import czd.wcssbackend.common.model.courseType.CourseInfo;
import czd.wcssbackend.web.controller.pojo.CourseCreateConfig;
import czd.wcssbackend.web.controller.pojo.CourseInfoCreateConfig;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.service.CourseInfoService;
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

import java.util.List;

/**
 * @ClassName CourseController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/16 21:10
 */
@Api(value = "CourseInfoController", description = "上课操作")
@RestController
@RequestMapping("/api/v1")
public class CourseInfoController {

    private static final Logger logger = LoggerFactory.getLogger(CourseInfoController.class);

    @Autowired
    CourseInfoService service;

    @ApiOperation(value = "获取上课", notes = "获取上课", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "classId", value = "classId", dataType = "integer", paramType = "path"),
    })
    @RequestMapping(value = "/class/{classId}", method = RequestMethod.GET,produces = "application/json")
    public CourseInfo getCourseInfo(@PathVariable("classId")String classId){
        int id=-1;
        try{
            id=Integer.valueOf(classId);
        } catch (NumberFormatException e)
        {

        }
        CourseInfo bean=null;
        if(id!=-1)
            bean=service.getCourseInfo(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该上课信息！").getMessage()); ;
        }
        logger.info("get courseInfo success:"+classId);
        return bean;
    }




    @ApiOperation(value = "获取上课列表", notes = "获取上课列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/class", method = RequestMethod.GET,produces = "application/json")
    public List<CourseInfo> listCourseInfos(@RequestParam(value = "keyword", required = false,defaultValue = "")String keyword)
    {
        return service.listCourseInfos();
    }

    @ApiOperation(value = "更新上课", notes = "上课", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseInfo", value = "courseInfo", dataType = "CourseInfo", paramType = "body"),
    })
    @RequestMapping(value = "/class", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateCourse(@RequestBody CourseInfo courseInfo)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.updateCourseInfo(courseInfo);
        }
        catch ( Exception e)
        {
            logger.error("update courseInfo failure:"+messageBox.getMessage());
            messageBox.setStatus(MessageBox.UPDATE_CLASS_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_CLASS_SUCCESS_CODE);
        messageBox.setMessage("update courseInfo success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "插入上课", notes = "插入上课", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "config", dataType = "CourseInfoCreateConfig", paramType = "body"),
    })
    @RequestMapping(value = "/class", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertParent(@RequestBody CourseInfoCreateConfig config)
    {
        CourseInfo courseInfo=createCourseInfoByConfig(config);
        MessageBox messageBox=new MessageBox();
        try{
            service.insertCourseInfo(courseInfo);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_CLASS_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_CLASS_SUCCESS_CODE);
        messageBox.setMessage("insert CLASS success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    private CourseInfo createCourseInfoByConfig(CourseInfoCreateConfig config)
    {
        CourseInfo courseInfo=new CourseInfo();
        courseInfo.setContent(config.getContent());
        courseInfo.setCourseId(config.getCourseId());
        courseInfo.setHomework(config.getHomework());
        courseInfo.setStuId(config.getStuId());
        courseInfo.setClassTime(config.getClassTime());
        courseInfo.setTeachId(config.getTeachId());
        return  courseInfo;
    }
}
