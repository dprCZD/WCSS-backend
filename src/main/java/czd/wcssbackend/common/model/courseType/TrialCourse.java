package czd.wcssbackend.common.model.courseType;

import  java.util.*;
/**
 * @ClassName TrialCourse
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/16 18:50
 */
public class TrialCourse {

    public final static int CHECK_SUCCESS_CODE=1;

    public final static int CHECKING_CODE=0;

    public final static int CHECK_FAILURE_CODE=1;

    private Integer trialId;

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

    public Integer getTrialId() {
        return trialId;
    }

    public void setTrialId(Integer trialId) {
        this.trialId = trialId;
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
