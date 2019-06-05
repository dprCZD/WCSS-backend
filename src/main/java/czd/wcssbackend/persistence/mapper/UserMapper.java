package czd.wcssbackend.persistence.mapper;

import czd.wcssbackend.common.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User getUser(@Param("id")int id);

    List<User> listUsers();

    void insertUser(@Param("user")User user);



}
