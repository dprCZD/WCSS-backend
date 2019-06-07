package czd.wcssbackend.web.security.UserHandler;

import com.fasterxml.jackson.databind.ObjectMapper;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class UserLogoutSuccessHandler implements LogoutSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger(LogoutSuccessHandler.class);

    @Autowired
    private ObjectMapper objectMapper;
    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if(authentication!=null) {
            log.info("登出成功");
            log.info("exception message" + authentication.getName());

        }
        else
        {
            log.info("登出异常：未登录");
            Map<String, Object> map = new HashMap<>();
            MessageBox message = new MessageBox();
            message.setStatus(1001);
            message.setMessage("Need Login");
            map.put("message", message);
            response.setContentType("application/json;charset=UTF-8");
            try {
                response.getWriter().write(objectMapper.writeValueAsString(map));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
