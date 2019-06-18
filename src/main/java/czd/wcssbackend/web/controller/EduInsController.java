package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.userType.EduIns;

import czd.wcssbackend.web.controller.pojo.EduInsCreateConfig;
import czd.wcssbackend.web.controller.pojo.MessageBox;

import czd.wcssbackend.web.service.EduInsService;

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
 * @ClassName EduInsController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:17
 */
@Api(value = "EduInsController", description = "教育机构操作")
@RestController
@RequestMapping("/api/v1")
public class EduInsController {

    private static final Logger logger = LoggerFactory.getLogger(EduInsController.class);

    @Autowired
    EduInsService service;

    @ApiOperation(value = "获取教育机构eduid", notes = "获取教育机构", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "eduId", value = "eduId", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/getEduInsByEduId/{eduId}", method = RequestMethod.GET,produces = "application/json")
    public EduIns getEduInsByEduId(@PathVariable("eduId")String eduId){
        int id=-1;
        try{
            id=Integer.valueOf(eduId);
        } catch (NumberFormatException e)
        {

        }
        EduIns bean=null;
        if(id!=-1)
            bean=service.getEduInsByEduId(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该账户信息！").getMessage()); ;
        }
        logger.info("get EduIns success:"+eduId);
        return bean;
    }

    @ApiOperation(value = "获取教育机构userId", notes = "获取教育机构", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "userId", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/getEduInsByUserId/{userId}", method = RequestMethod.GET,produces = "application/json")
    public EduIns getEduInsByUserId(@PathVariable("userId")String userId){
        int id=-1;
        try{
            id=Integer.valueOf(userId);
        } catch (NumberFormatException e)
        {

        }
        EduIns bean=null;
        if(id!=-1)
            bean=service.getEduInsByUserId(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该账户信息！").getMessage()); ;
        }
        logger.info("get EduIns success:"+userId);
        return bean;
    }


    @ApiOperation(value = "获取教育机构列表", notes = "获取教育机构列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/eduIns", method = RequestMethod.GET,produces = "application/json")
    public List<EduIns> listEduInss(@RequestParam(value = "keyword", required = false,defaultValue = "")String keyword)
    {
        return service.listEduInss();
    }

    @ApiOperation(value = "更新教育机构", notes = "更新教育机构", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "eduIns", value = "eduIns", dataType = "EduIns", paramType = "body"),
    })
    @RequestMapping(value = "/eduIns", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateEduIns(@RequestBody EduIns eduIns)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.updateEduInsByEduId(eduIns);
        }
        catch ( Exception e)
        {

            messageBox.setStatus(MessageBox.UPDATE_EDUINS_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error("update EduIns failure:"+messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_EDUINS_SUCCESS_CODE);
        messageBox.setMessage("update EduIns success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "插入教育机构", notes = "插入教育机构", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "config", dataType = "EduInsCreateConfig", paramType = "body"),
    })
    @RequestMapping(value = "/eduIns", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertEduIns(@RequestBody EduInsCreateConfig config)
    {
        EduIns eduIns=createEduInsByConfig(config);
        MessageBox messageBox=new MessageBox();
        try{
            service.insertEduIns(eduIns);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_EDUINS_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_EDUINS_SUCCESS_CODE);
        messageBox.setMessage("insert EduIns success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    private EduIns createEduInsByConfig(EduInsCreateConfig config)
    {
        EduIns eduIns =new EduIns();
        eduIns.setEduField(config.getEduField());
        eduIns.setEduFitAge(config.getEduFitAge());
        eduIns.setEduIdNumber(config.getEduIdNumber());
        eduIns.setEduIntroduction(config.getEduIntroduction());
        eduIns.setEduLocation(config.getEduLocation());
        eduIns.setEduName(config.getEduName());
        eduIns.setEduTel(config.getEduTel());
        eduIns.setUserId(config.getUserId());
        return  eduIns;
    }
}
