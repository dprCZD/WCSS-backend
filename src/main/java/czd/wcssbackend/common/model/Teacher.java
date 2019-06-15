package czd.wcssbackend.common.model;

/**
 * @ClassName Teacher
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 16:32
 */
public class Teacher {

    private Integer teachId;

    private Integer userId;

    private String teachName;

    private String teachGender;

    private String teachSubject;

    private Integer teachYears;

    private Integer teachFitAge;

    private String teachIdNumber;

    private String teachTel;

    private String teachIntroduction;

    public Integer getTeachId() {
        return teachId;
    }

    public void setTeachId(Integer teachId) {
        this.teachId = teachId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTeachName() {
        return teachName;
    }

    public void setTeachName(String teachName) {
        this.teachName = teachName;
    }

    public String getTeachGender() {
        return teachGender;
    }

    public void setTeachGender(String teachGender) {
        this.teachGender = teachGender;
    }

    public String getTeachSubject() {
        return teachSubject;
    }

    public void setTeachSubject(String teachSubject) {
        this.teachSubject = teachSubject;
    }

    public Integer getTeachYears() {
        return teachYears;
    }

    public void setTeachYears(Integer teachYears) {
        this.teachYears = teachYears;
    }

    public Integer getTeachFitAge() {
        return teachFitAge;
    }

    public void setTeachFitAge(Integer teachFitAge) {
        this.teachFitAge = teachFitAge;
    }

    public String getTeachIdNumber() {
        return teachIdNumber;
    }

    public void setTeachIdNumber(String teachIdNumber) {
        this.teachIdNumber = teachIdNumber;
    }

    public String getTeachTel() {
        return teachTel;
    }

    public void setTeachTel(String teachTel) {
        this.teachTel = teachTel;
    }

    public String getTeachIntroduction() {
        return teachIntroduction;
    }

    public void setTeachIntroduction(String teachIntroduction) {
        this.teachIntroduction = teachIntroduction;
    }
}
