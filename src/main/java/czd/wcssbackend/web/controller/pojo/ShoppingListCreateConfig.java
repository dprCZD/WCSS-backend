package czd.wcssbackend.web.controller.pojo;

/**
 * @ClassName ShoppingListCreateConfig
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/18 16:47
 */
public class ShoppingListCreateConfig {

    private Integer courseId;

    private Integer shopNum;

    private Integer parId;

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

    public Integer getShopNum() {
        return shopNum;
    }

    public void setShopNum(Integer shopNum) {
        this.shopNum = shopNum;
    }
}
