package czd.wcssbackend.common.model.systemType;

import java.util.Date;
/**
 * @ClassName Notice
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/19 14:19
 */
public class Notice {

    private Integer noticeId;

    private Integer teacherId;

    private String noticePic;

    private String noticeWords;

    private Date noticeTime;

    public Integer getNoticeId() {
        return noticeId;
    }

    public void setNoticeId(Integer noticeId) {
        this.noticeId = noticeId;
    }

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
