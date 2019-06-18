package czd.wcssbackend.common.model.courseType;

import java.util.Date;
/**
 * @ClassName CourseInfo
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/16 17:29
 */
public class CourseInfo {
    private Integer classId;

    private Integer courseId;

    private Integer teachId;

    private Integer stuId;

    private Date classTime;

    private String content;

    private String homework;

    public Date getClassTime() {
        return classTime;
    }

    public void setClassTime(Date classTime) {
        this.classTime = classTime;
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getTeachId() {
        return teachId;
    }

    public void setTeachId(Integer teachId) {
        this.teachId = teachId;
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getHomework() {
        return homework;
    }

    public void setHomework(String homework) {
        this.homework = homework;
    }
}
