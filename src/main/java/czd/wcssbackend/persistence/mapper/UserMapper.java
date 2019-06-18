package czd.wcssbackend.persistence.mapper;

import czd.wcssbackend.common.model.userType.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUser(@Param("id")int id);

    User getUserByName(@Param("userName")String userName);

    User getUserByPhone(@Param("phoneNum")String phoneNum);

    User getUserByEmail(@Param("email")String email);

    List<User> listUsers();

    void updateUser(@Param("user")User user);

    void insertUser(@Param("user")User user);

    void deleteUser(@Param("id")int id);



}
