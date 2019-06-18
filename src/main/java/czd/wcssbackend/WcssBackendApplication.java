package czd.wcssbackend;

import czd.wcssbackend.common.model.userType.User;
import czd.wcssbackend.web.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.List;

@SpringBootApplication
public class WcssBackendApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(WcssBackendApplication.class, args);
		UserService service=(UserService)context.getBean("getUserService");
		List<User> user=service.listUsers();
		System.out.println(user.toString());
	}

}
