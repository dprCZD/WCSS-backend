package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.Parent;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.controller.pojo.ParentCreateConfig;
import czd.wcssbackend.web.service.ParentService;
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
 * @ClassName ParentController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:17
 */
@Api(value = "ParentController", description = "家长操作")
@RestController
@RequestMapping("/api/v1")
public class ParentController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    ParentService service;

    @ApiOperation(value = "获取家长parid", notes = "获取家长", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parId", value = "parId", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/getParentByParId/{parId}", method = RequestMethod.GET,produces = "application/json")
    public Parent getParentByParId(@PathVariable("parId")String parId){
        int id=-1;
        try{
            id=Integer.valueOf(parId);
        } catch (NumberFormatException e)
        {

        }
        Parent parBean=null;
        if(id!=-1)
            parBean=service.getParentByParId(id);
        if(parBean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该账户信息！").getMessage()); ;
        }
        logger.info("get parent success:"+parId);
        return parBean;
    }

    @ApiOperation(value = "获取家长userId", notes = "获取家长", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "userId", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/getParentByUserId/{userId}", method = RequestMethod.GET,produces = "application/json")
    public Parent getParentByUserId(@PathVariable("userId")String userId){
        int id=-1;
        try{
            id=Integer.valueOf(userId);
        } catch (NumberFormatException e)
        {

        }
        Parent parBean=null;
        if(id!=-1)
            parBean=service.getParentByUserId(id);
        if(parBean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该账户信息！").getMessage()); ;
        }
        logger.info("get parent success:"+userId);
        return parBean;
    }


    @ApiOperation(value = "获取家长列表", notes = "获取家长列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/parent", method = RequestMethod.GET,produces = "application/json")
    public List<Parent> listUsers(@RequestParam(value = "keyword", required = false,defaultValue = "")String keyword)
    {
        return service.listParents();
    }

    @ApiOperation(value = "更新家长", notes = "更新家长", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parent", value = "parent", dataType = "Parent", paramType = "body"),
    })
    @RequestMapping(value = "/parent", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateParent(@RequestBody Parent parent)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.updateParentByParId(parent);
        }
        catch ( Exception e)
        {
            logger.error("update parent failure:"+messageBox.getMessage());
            messageBox.setStatus(MessageBox.UPDATE_PARENT_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_PARENT_SUCCESS_CODE);
        messageBox.setMessage("update parent success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "插入家长", notes = "插入家长", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "config", dataType = "ParentCreateConfig", paramType = "body"),
    })
    @RequestMapping(value = "/parent", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertParent(@RequestBody ParentCreateConfig config)
    {
        Parent parent=createParentByConfig(config);
        MessageBox messageBox=new MessageBox();
        try{
            service.insertParent(parent);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_PARENT_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_PARENT_SUCCESS_CODE);
        messageBox.setMessage("insert parent success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    private Parent createParentByConfig(ParentCreateConfig config)
    {
        Parent parent =new Parent();
        parent.setParName(config.getParName());
        parent.setParTel(config.getParTel());
        parent.setUserId(config.getUserId());
        return  parent;
    }
}
