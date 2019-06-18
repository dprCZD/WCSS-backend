package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.courseType.TrialCourse;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.controller.pojo.TrialCourseCreateConfig;
import czd.wcssbackend.web.service.TrialCourseService;
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
 * @ClassName TrialCourseController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/17 23:22
 */
@Api(value = "TrialCourseontroller", description = "试听课程操作")
@RestController
@RequestMapping("/api/v1")
public class TrialCourseController {

    private static final Logger logger = LoggerFactory.getLogger(TrialCourseController.class);

    @Autowired
    TrialCourseService service;

    @ApiOperation(value = "获取试听课程", notes = "获取试听课程", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "trialId", value = "trialId", dataType = "integer", paramType = "path"),
    })
    @RequestMapping(value = "/trial/{trialId}", method = RequestMethod.GET,produces = "application/json")
    public TrialCourse getTrialCourse(@PathVariable("trialId")String trialId){
        int id=-1;
        try{
            id=Integer.valueOf(trialId);
        } catch (NumberFormatException e)
        {

        }
        TrialCourse bean=null;
        if(id!=-1)
            bean=service.getTrialCourse(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该试听课程信息！").getMessage()); ;
        }
        logger.info("get TrialCourse success:"+trialId);
        return bean;
    }




    @ApiOperation(value = "获取试听课程列表", notes = "获取试听课程列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/trial", method = RequestMethod.GET,produces = "application/json")
    public List<TrialCourse> listTrialCourses(@RequestParam(value = "keyword", required = false,defaultValue = "")String keyword)
    {
        return service.listTrialCourses();
    }

    @ApiOperation(value = "更新试听课程", notes = "试听课程", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "trialCourse", value = "trialCourse", dataType = "TrialCourse", paramType = "body"),
    })
    @RequestMapping(value = "/trial", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateCourse(@RequestBody TrialCourse trialCourse)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.updateTrialCourse(trialCourse);
        }
        catch ( Exception e)
        {
            logger.error("update TrialCourse failure:"+messageBox.getMessage());
            messageBox.setStatus(MessageBox.UPDATE_TRIAL_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_TRIAL_SUCCESS_CODE);
        messageBox.setMessage("update TrialCourse success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "插入试听课程", notes = "插入试听课程", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "config", dataType = "TrialCourseCreateConfig", paramType = "body"),
    })
    @RequestMapping(value = "/trial", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertTrialCourse(@RequestBody TrialCourseCreateConfig config)
    {
        TrialCourse trialCourse=createTrialCourseByConfig(config);
        MessageBox messageBox=new MessageBox();
        try{
            service.insertTrialCourse(trialCourse);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_TRIAL_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_TRIAL_SUCCESS_CODE);
        messageBox.setMessage("insert TrialCourse success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    private TrialCourse createTrialCourseByConfig(TrialCourseCreateConfig config)
    {
        TrialCourse course=new TrialCourse();
        course.setParId(config.getParId());
        course.setTrialCheck(config.getTrialCheck());
        course.setCourseId(config.getCourseId());
        course.setTrialTime(config.getTrialTime());
        return  course;
    }
}
