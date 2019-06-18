package czd.wcssbackend.web.impl;

import czd.wcssbackend.common.model.userType.Student;
import czd.wcssbackend.persistence.mapper.StudentMapper;
import czd.wcssbackend.web.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName ParentServiceImpl
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:15
 */
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentMapper mapper;
    @Override
    public Student getStudentByStuId(Integer stuId) {
        return mapper.getStudentByStuId(stuId);
    }

    @Override
    public List<Student> getStudentByUserId(Integer userId) {
        return mapper.getStudentByUserId(userId);
    }

    @Override
    public List<Student> listStudents() {
        return mapper.listStudents();
    }

    @Override
    public void updateStudentByStuId(Student student) {
        mapper.updateStudentByStuId(student);
    }

    @Override
    public void insertStudent(Student student) {
        mapper.insertStudent(student);
    }
}
