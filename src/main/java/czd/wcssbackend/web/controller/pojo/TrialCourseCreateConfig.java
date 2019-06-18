package czd.wcssbackend.web.controller.pojo;

import java.util.Date;

/**
 * @ClassName TrialCourseCreateConfig
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/17 23:21
 */
public class TrialCourseCreateConfig {

    private Integer parId;

    private Integer courseId;

    private Date trialTime;

    private Integer trialCheck;


    public Integer getTrialCheck() {
        return trialCheck;
    }

    public void setTrialCheck(Integer trialCheck) {
        this.trialCheck = trialCheck;
    }

    public Integer getParId() {
        return parId;
    }

    public void setParId(Integer parId) {
        this.parId = parId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Date getTrialTime() {
        return trialTime;
    }

    public void setTrialTime(Date trialTime) {
        this.trialTime = trialTime;
    }


}
