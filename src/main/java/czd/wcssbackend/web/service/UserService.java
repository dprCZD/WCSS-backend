package czd.wcssbackend.web.service;

import czd.wcssbackend.common.model.User;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
     User getUser(int id);

     User getUserByName(String userName);

     User getUserByPhone(String phoneNum);

     User getUserByEmail(String email);

     List<User> listUsers();

     void insertUser(User user);
}
