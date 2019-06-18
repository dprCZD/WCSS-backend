package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.userType.User;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.service.UserService;
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
 * @ClassName UserController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 15:16
 */
@Api(value = "UserController", description = "用户操作")
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    UserService userService;

    @ApiOperation(value = "获取用户", notes = "获取用户", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "id/email/phone/name", dataType = "string", paramType = "path"),
    })
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.GET,produces = "application/json")
    public User getUser(@PathVariable("userId")String userId){
        int id=-1;
        try{
            id=Integer.valueOf(userId);
        } catch (NumberFormatException e)
        {

        }
        User userBean=null;
        if(id!=-1)
            userBean=userService.getUser(Integer.valueOf(userId));
        if(userBean==null)
        {
            if((userBean=userService.getUserByName(userId))==null)
                if((userBean=userService.getUserByPhone(userId))==null)
                    if((userBean=userService.getUserByEmail(userId))==null)
                        logger.error(new UsernameNotFoundException("找不到该账户信息！").getMessage()); ;
        }
        return userBean;
    }

    @ApiOperation(value = "获取用户列表", notes = "获取用户列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "", dataType = "String", paramType = "query"),
    })
    @RequestMapping(value = "/user", method = RequestMethod.GET,produces = "application/json")
    public List<User> listUsers(@RequestParam(value = "keyword", required = false,defaultValue = "")String keyword)
    {
        return userService.listUsers();
    }
    @ApiOperation(value = "删除用户", notes = "删除用户", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userId", value = "id", dataType = "String", paramType = "path"),
    })
    @RequestMapping(value = "/user/{userId}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteUser(@PathVariable("userId") String userId)
    {
        MessageBox messageBox=new MessageBox();
        try{
            userService.deleteUser(Integer.valueOf(userId));
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_USER_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_USER_SUCCESS_CODE);
        messageBox.setMessage("delete user success");
        return messageBox;
    }
    @ApiOperation(value = "更新用户", notes = "更新用户", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "user", value = "user", dataType = "User", paramType = "body"),
    })
    @RequestMapping(value = "/user", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateUser(@RequestBody User user)
    {
        MessageBox messageBox=new MessageBox();
        try{
            userService.updateUser(user);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.UPDATE_USER_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_USER_SUCCESS_CODE);
        messageBox.setMessage("update user success");
        return messageBox;
    }
}
