package czd.wcssbackend.web.security.UserHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import czd.wcssbackend.common.model.User;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserAuthenticationSuccessHandler implements AuthenticationSuccessHandler {


    private static final Logger log = LoggerFactory.getLogger(UserAuthenticationSuccessHandler.class);

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private UserService userService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        log.info("登录成功");
        log.info("username=>" + authentication.getName());
        Map<String, Object> map = new HashMap<>();
        MessageBox message=new MessageBox();
        message.setStatus(1);
        message.setMessage("Load Success");
        map.put("message",message);
        User user=userService.getUser(Integer.valueOf(authentication.getName()));
        map.put("data",user);
        response.setContentType("application/json;charset=UTF-8");
        try {
            response.getWriter().write(objectMapper.writeValueAsString(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
