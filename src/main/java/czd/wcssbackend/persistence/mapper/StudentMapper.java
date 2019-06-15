package czd.wcssbackend.persistence.mapper;

import czd.wcssbackend.common.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName StudentMapper
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:05
 */

@Mapper
public interface StudentMapper {
    Student getStudentByStuId(@Param("stuId") Integer stuId);

    List<Student>  getStudentByUserId(@Param("userId") Integer userId);

    List<Student> listStudents();

    void updateStudentByStuId(@Param("student") Student student);

    void insertStudent(@Param("student") Student student);
}
