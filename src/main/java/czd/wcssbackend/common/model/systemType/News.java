package czd.wcssbackend.common.model.systemType;

import java.util.Date;

/**
 * @ClassName News
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/19 14:19
 */
public class News {

    private Integer newsId;

    private Integer userId;

    private String newsWords;

    private String newsResource;

    private Date newsTime;

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNewsWords() {
        return newsWords;
    }

    public void setNewsWords(String newsWords) {
        this.newsWords = newsWords;
    }

    public String getNewsResource() {
        return newsResource;
    }

    public void setNewsResource(String newsResource) {
        this.newsResource = newsResource;
    }

    public Date getNewsTime() {
        return newsTime;
    }

    public void setNewsTime(Date newsTime) {
        this.newsTime = newsTime;
    }
}
