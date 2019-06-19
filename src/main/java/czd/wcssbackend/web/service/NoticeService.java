package czd.wcssbackend.web.service;

import czd.wcssbackend.common.model.systemType.Notice;

import java.util.List;

/**
 * @ClassName NoticeService
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/19 15:00
 */
public interface NoticeService {

    Notice getNotice(Integer noticeId);

    void insertNotice(Notice notice);

    void updateNotice(Notice notice);

    void deleteNotice(Integer noticeId);

    List<Notice> listNotices();
}
