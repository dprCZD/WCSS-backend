package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.User;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.controller.pojo.UserRegisterConfig;
import czd.wcssbackend.web.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


@Api(value = "AuthController", description = "用户认证服务")
@RestController
@RequestMapping("/api/v1")
public class AuthController {

    private static final Logger logger = LoggerFactory.getLogger(AuthController.class);

    @Autowired
    UserService service;


    @ApiOperation(value = "注册服务", notes = "注册服务", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "UserRegisterConfig", dataType = "UserRegisterConfig", paramType = "body"),
    })
    @RequestMapping(value = "/doRegister", method = RequestMethod.POST,produces = "application/json")
    public MessageBox doRegister(@RequestBody UserRegisterConfig config){
        User user=UserCreateFactory(config);
        MessageBox message=new MessageBox();
        Boolean isName=service.getUserByName(config.getName())==null;
        Boolean isEmail=service.getUserByEmail(config.getEmail())==null;
        Boolean isPhone=service.getUserByPhone(config.getPhoneNum())==null;
        if(!(isEmail&&isName&&isPhone))
        {
            message.setStatus(MessageBox.REGISTER_FAILURE_CODE);
            message.setMessage("注册失败:用户数据已存在。"
                    +(isName?" ":"昵称:"+config.getName())
                    +(isEmail?" ":"邮箱:"+config.getEmail())
                    +(isPhone?" ":"手机号:"+config.getPhoneNum()));
            logger.error(message.getMessage());
            return message;
        }
        try{
            service.insertUser(user);
        }
        catch (Exception e)
        {
            message.setStatus(MessageBox.REGISTER_FAILURE_CODE);
            message.setMessage(e.getMessage());
            logger.error(message.getMessage());
            return message;
        }

        message.setStatus(MessageBox.REGISTER_SUCCESS_CODE);
        message.setMessage("注册成功!用户名:"+config.getEmail());
        logger.info(message.getMessage());
        return message;
    }
    @ApiOperation(value = "登录服务提交数据", notes = "提交数据测试用", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "loginData", value = "Json", dataType = "String", paramType = "body"),
    })
    @RequestMapping(value="/login/form",method = RequestMethod.POST,produces = "application/json")
    public void loginForm(){

    }

    @ApiOperation(value = "登录服务", notes = "接口展示用", produces = "application/json")
    @RequestMapping(value = "/login",method = {RequestMethod.GET,RequestMethod.POST},produces = "application/json")
    public Object authenticationLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {

        // 如果是需要返回json数据，则返回需要登录的信息提示
        Map<String, Object> map = new HashMap<>();
        map.put("code", MessageBox.NOT_LOGIN_CODE);
        map.put("msg", "Need Login");
        return map;
    }

    @ApiOperation(value = "登出接口展示用", notes = "展示用", produces = "application/json")
    @RequestMapping(value="/logout",method = RequestMethod.POST,produces = "application/json")
    public void logout(){

    }

    private User UserCreateFactory(UserRegisterConfig config)
    {
        User user=new User();
        user.setEmail(config.getEmail());
        user.setIdentity(config.getIdentity());
        user.setPassword(config.getPassword());
        user.setName(config.getName());
        user.setPhoneNum(config.getPhoneNum());
        return user;
    }

}
