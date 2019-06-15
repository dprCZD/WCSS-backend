package czd.wcssbackend.web.controller.pojo;

/**
 * @ClassName EduInsCreateConfig
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/15 18:31
 */
public class EduInsCreateConfig {

    private Integer userId;

    private String eduIdNumber;

    private String eduName;

    private String eduField;

    private String eduLocation;

    private Integer eduFitAge;

    private String eduTel;

    private String eduIntroduction;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getEduIdNumber() {
        return eduIdNumber;
    }

    public void setEduIdNumber(String eduIdNumber) {
        this.eduIdNumber = eduIdNumber;
    }

    public String getEduName() {
        return eduName;
    }

    public void setEduName(String eduName) {
        this.eduName = eduName;
    }

    public String getEduField() {
        return eduField;
    }

    public void setEduField(String eduField) {
        this.eduField = eduField;
    }

    public String getEduLocation() {
        return eduLocation;
    }

    public void setEduLocation(String eduLocation) {
        this.eduLocation = eduLocation;
    }

    public Integer getEduFitAge() {
        return eduFitAge;
    }

    public void setEduFitAge(Integer eduFitAge) {
        this.eduFitAge = eduFitAge;
    }

    public String getEduTel() {
        return eduTel;
    }

    public void setEduTel(String eduTel) {
        this.eduTel = eduTel;
    }

    public String getEduIntroduction() {
        return eduIntroduction;
    }

    public void setEduIntroduction(String eduIntroduction) {
        this.eduIntroduction = eduIntroduction;
    }
}
