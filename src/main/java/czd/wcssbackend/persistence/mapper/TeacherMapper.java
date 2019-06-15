package czd.wcssbackend.persistence.mapper;

import czd.wcssbackend.common.model.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName TeacherMapper
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:05
 */

@Mapper
public interface TeacherMapper {
    Teacher getTeacherByTeachId(@Param("teachId") Integer teachId);

    Teacher getTeacherByUserId(@Param("userId") Integer userId);

    List<Teacher> listTeachers();

    void updateTeacherByTeachId(@Param("teacher") Teacher teacher);

    void insertTeacher(@Param("teacher") Teacher teacher);
}
