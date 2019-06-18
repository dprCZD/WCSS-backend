package czd.wcssbackend.web.controller.pojo;

import java.util.Date;

/**
 * @ClassName PaidCourseCreateConfig
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/17 20:15
 */
public class PaidCourseCreateConfig {

    private Integer courseId;

    private Integer parId;

    private Integer paidNum;

    private Integer paidExpense;

    private Date paidTime;

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getParId() {
        return parId;
    }

    public void setParId(Integer parId) {
        this.parId = parId;
    }

    public Integer getPaidNum() {
        return paidNum;
    }

    public void setPaidNum(Integer paidNum) {
        this.paidNum = paidNum;
    }

    public Integer getPaidExpense() {
        return paidExpense;
    }

    public void setPaidExpense(Integer paidExpense) {
        this.paidExpense = paidExpense;
    }

    public Date getPaidTime() {
        return paidTime;
    }

    public void setPaidTime(Date paidTime) {
        this.paidTime = paidTime;
    }
}
