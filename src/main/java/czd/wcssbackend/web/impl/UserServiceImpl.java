package czd.wcssbackend.web.impl;

import czd.wcssbackend.common.model.User;
import czd.wcssbackend.persistence.mapper.UserMapper;
import czd.wcssbackend.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Autowired
    UserMapper mapper;

    @Override
    public User getUser(int id) {
        return mapper.getUser(id);
    }

    @Override
    public List<User> listUsers() {
        return mapper.listUsers();
    }

    @Override
    public void insertUser(User user) {
        mapper.insertUser(user);
    }
}
