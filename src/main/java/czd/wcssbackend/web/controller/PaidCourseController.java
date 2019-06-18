package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.courseType.PaidCourse;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.controller.pojo.PaidCourseCreateConfig;
import czd.wcssbackend.web.service.PaidCourseService;
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
 * @ClassName PaidCourseController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/16 21:10
 */
@Api(value = "PaidCourseontroller", description = "付费课程操作")
@RestController
@RequestMapping("/api/v1")
public class PaidCourseController {

    private static final Logger logger = LoggerFactory.getLogger(PaidCourseController.class);

    @Autowired
    PaidCourseService service;

    @ApiOperation(value = "获取付费课程", notes = "获取付费课程", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paidId", value = "paidId", dataType = "integer", paramType = "path"),
    })
    @RequestMapping(value = "/paid/{paidId}", method = RequestMethod.GET,produces = "application/json")
    public PaidCourse getPaidCourse(@PathVariable("paidId")String paidId){
        int id=-1;
        try{
            id=Integer.valueOf(paidId);
        } catch (NumberFormatException e)
        {

        }
        PaidCourse bean=null;
        if(id!=-1)
            bean=service.getPaidCourse(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该付费课程信息！").getMessage()); ;
        }
        logger.info("get PaidCourse success:"+paidId);
        return bean;
    }




    @ApiOperation(value = "获取付费课程列表", notes = "获取付费课程列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/paid", method = RequestMethod.GET,produces = "application/json")
    public List<PaidCourse> listPaidCourses(@RequestParam(value = "keyword", required = false,defaultValue = "")String keyword)
    {
        return service.listPaidCourses();
    }

    @ApiOperation(value = "更新付费课程", notes = "付费课程", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "paidCourse", value = "paidCourse", dataType = "PaidCourse", paramType = "body"),
    })
    @RequestMapping(value = "/paid", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateCourse(@RequestBody PaidCourse paidCourse)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.updatePaidCourse(paidCourse);
        }
        catch ( Exception e)
        {
            logger.error("update PaidCourse failure:"+messageBox.getMessage());
            messageBox.setStatus(MessageBox.UPDATE_PAID_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_PAID_SUCCESS_CODE);
        messageBox.setMessage("update PaidCourse success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "插入付费课程", notes = "插入付费课程", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "config", dataType = "PaidCourseCreateConfig", paramType = "body"),
    })
    @RequestMapping(value = "/paid", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertParent(@RequestBody PaidCourseCreateConfig config)
    {
        PaidCourse paidCourse=createPaidCourseByConfig(config);
        MessageBox messageBox=new MessageBox();
        try{
            service.insertPaidCourse(paidCourse);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_PAID_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_PAID_SUCCESS_CODE);
        messageBox.setMessage("insert PaidCourse success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    private PaidCourse createPaidCourseByConfig(PaidCourseCreateConfig config)
    {
        PaidCourse paidCourse=new PaidCourse();
        paidCourse.setCourseId(config.getCourseId());
        paidCourse.setPaidExpense(config.getPaidExpense());
        paidCourse.setPaidNum(config.getPaidNum());
        paidCourse.setPaidTime(config.getPaidTime());
        paidCourse.setParId(config.getParId());
        return  paidCourse;
    }
}
