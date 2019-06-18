package czd.wcssbackend.common.model.courseType;
import  java.util.Date;


/**
 * @ClassName Course
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/16 17:07
 */
public class Course {

    private Integer courseId;

    private String courseName;

    private String teacherName;

    private Integer teacherId;

    private Date courseTime;

    private String courseLocation;

    private Integer courseFitAge;

    private Double coursePrice;

    private String courseDirection;

    private Double courseUserStars;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
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

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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

    public String getCourseDirection() {
        return courseDirection;
    }

    public void setCourseDirection(String courseDirection) {
        this.courseDirection = courseDirection;
    }

    public Double getCourseUserStars() {
        return courseUserStars;
    }

    public void setCourseUserStars(Double courseUserStars) {
        this.courseUserStars = courseUserStars;
    }
}
