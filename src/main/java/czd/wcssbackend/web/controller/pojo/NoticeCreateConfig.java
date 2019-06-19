package czd.wcssbackend.web.controller.pojo;

import java.util.Date;

/**
 * @ClassName NoticeCreateConfig
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/19 15:04
 */
public class NoticeCreateConfig {

    private Integer teacherId;

    private String noticePic;

    private String noticeWords;

    private Date noticeTime;

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getNoticePic() {
        return noticePic;
    }

    public void setNoticePic(String noticePic) {
        this.noticePic = noticePic;
    }

    public String getNoticeWords() {
        return noticeWords;
    }

    public void setNoticeWords(String noticeWords) {
        this.noticeWords = noticeWords;
    }

    public Date getNoticeTime() {
        return noticeTime;
    }

    public void setNoticeTime(Date noticeTime) {
        this.noticeTime = noticeTime;
    }
}
