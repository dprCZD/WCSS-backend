package czd.wcssbackend.web.controller.pojo;

/**
 * @ClassName ParentCreateConfig
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:49
 */
public class ParentCreateConfig {
    private Integer userId;

    private String parName;

    private String parTel;

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
