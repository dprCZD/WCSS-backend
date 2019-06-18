package czd.wcssbackend.web.controller.pojo;

/**
 * @ClassName TrialReviewCreateConfig
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/18 18:24
 */
public class TrialReviewCreateConfig {

    private Integer parId;

    private Integer trialId;

    private Integer reviewCourse;

    private Integer reviewTeacher;

    private String reviewPic;

    private String reviewWords;

    private Integer reviewStars;

    private Integer courseId;

    public Integer getParId() {
        return parId;
    }

    public void setParId(Integer parId) {
        this.parId = parId;
    }

    public Integer getTrialId() {
        return trialId;
    }

    public void setTrialId(Integer trialId) {
        this.trialId = trialId;
    }

    public Integer getReviewCourse() {
        return reviewCourse;
    }

    public void setReviewCourse(Integer reviewCourse) {
        this.reviewCourse = reviewCourse;
    }

    public Integer getReviewTeacher() {
        return reviewTeacher;
    }

    public void setReviewTeacher(Integer reviewTeacher) {
        this.reviewTeacher = reviewTeacher;
    }

    public String getReviewPic() {
        return reviewPic;
    }

    public void setReviewPic(String reviewPic) {
        this.reviewPic = reviewPic;
    }

    public String getReviewWords() {
        return reviewWords;
    }

    public void setReviewWords(String reviewWords) {
        this.reviewWords = reviewWords;
    }

    public Integer getReviewStars() {
        return reviewStars;
    }

    public void setReviewStars(Integer reviewStars) {
        this.reviewStars = reviewStars;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }
}
