package czd.wcssbackend.web.controller.pojo;

import java.util.Date;

/**
 * @ClassName CourseCreateConfig
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/16 21:24
 */
public class CourseCreateConfig {

    private String courseName;

    private String teacherName;

    private Date courseTime;

    private Integer teacherId;

    private String courseLocation;

    private Integer courseFitAge;

    private Double coursePrice;

    private Double courseUserStars;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public Double getCourseUserStars() {
        return courseUserStars;
    }

    public void setCourseUserStars(Double courseUserStars) {
        this.courseUserStars = courseUserStars;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Date getCourseTime() {
        return courseTime;
    }

    public void setCourseTime(Date courseTime) {
        this.courseTime = courseTime;
    }

    public String getCourseLocation() {
        return courseLocation;
    }

    public void setCourseLocation(String courseLocation) {
        this.courseLocation = courseLocation;
    }

    public Integer getCourseFitAge() {
        return courseFitAge;
    }

    public void setCourseFitAge(Integer courseFitAge) {
        this.courseFitAge = courseFitAge;
    }

    public Double getCoursePrice() {
        return coursePrice;
    }

    public void setCoursePrice(Double coursePrice) {
        this.coursePrice = coursePrice;
    }
}
