package czd.wcssbackend.common.model.userType;

import java.util.Date;

/**
 * @ClassName Student
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 16:29
 */
public class Student {

    private Integer stuId;

    private Integer userId;

    private String  stuName;

    private String  stuSex;


    private Date stuBornDate;

    private String stuSelectCourse;

    private double stuLowPrice;

    private double stuHighPrice;

    private String stuLocation;

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }


    public Date getStuBornDate() {
        return stuBornDate;
    }

    public void setStuBornDate(Date stuBornDate) {
        this.stuBornDate = stuBornDate;
    }

    public String getStuSelectCourse() {
        return stuSelectCourse;
    }

    public void setStuSelectCourse(String stuSelectCourse) {
        this.stuSelectCourse = stuSelectCourse;
    }

    public double getStuLowPrice() {
        return stuLowPrice;
    }

    public void setStuLowPrice(double stuLowPrice) {
        this.stuLowPrice = stuLowPrice;
    }

    public double getStuHighPrice() {
        return stuHighPrice;
    }

    public void setStuHighPrice(double stuHighPrice) {
        this.stuHighPrice = stuHighPrice;
    }

    public String getStuLocation() {
        return stuLocation;
    }

    public void setStuLocation(String stuLocation) {
        this.stuLocation = stuLocation;
    }
}
