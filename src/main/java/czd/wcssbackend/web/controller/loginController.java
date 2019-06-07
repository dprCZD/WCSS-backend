package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.User;
import czd.wcssbackend.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
//测试用
@Controller
public class loginController {


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


}
