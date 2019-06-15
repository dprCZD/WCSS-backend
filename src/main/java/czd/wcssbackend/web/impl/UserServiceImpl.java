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
    public User getUserByName(String userName) {
        return mapper.getUserByName(userName);
    }

    @Override
    public User getUserByPhone(String phoneNum) {
        return mapper.getUserByPhone(phoneNum);
    }

    @Override
    public User getUserByEmail(String email) {
        return mapper.getUserByEmail(email);
    }

    @Override
    public void updateUser(User user)throws Exception {
        mapper.updateUser(user);
    }

    @Override
    public List<User> listUsers() {
        return mapper.listUsers();
    }

    @Override
    public void insertUser(User user) throws Exception{
        mapper.insertUser(user);
    }

    @Override
    public void deleteUser(int id)throws Exception {
        mapper.deleteUser(id);
    }
}
