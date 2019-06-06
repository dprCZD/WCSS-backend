package czd.wcssbackend.web.login;

import czd.wcssbackend.common.model.User;
import czd.wcssbackend.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//登陆模块控制器
@Controller
public class loginController {
    @Autowired
    UserService service;

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "registor";
    }

    @RequestMapping("/doRegister")
    public String doRegister(String username,String password){
        User user=new User();
        user.setName(username);
        user.setPassword(password);
        user.setIdentity("user");
        user.setEmail("9395");
        service.insertUser(user);
        return user==null?"forward:/register":"forward:index";
    }
}
