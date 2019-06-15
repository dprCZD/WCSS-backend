package czd.wcssbackend.common.model;

/**
 * @ClassName Parent
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 16:29
 */
public class Parent {

    private Integer parId;

    private Integer userId;

    private String parName;

    private String parTel;

    public Integer getParId() {
        return parId;
    }

    public void setParId(Integer parId) {
        this.parId = parId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getParName() {
        return parName;
    }

    public void setParName(String parName) {
        this.parName = parName;
    }

    public String getParTel() {
        return parTel;
    }

    public void setParTel(String parTel) {
        this.parTel = parTel;
    }
}
