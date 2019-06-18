package czd.wcssbackend.common.model.systemType;

/**
 * @ClassName ShoppingList
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/18 16:41
 */
public class ShoppingList {

    private Integer shopId;

    private Integer courseId;

    private Integer shopNum;

    private Integer parId;

    public Integer getParId() {
        return parId;
    }

    public void setParId(Integer parId) {
        this.parId = parId;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
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
