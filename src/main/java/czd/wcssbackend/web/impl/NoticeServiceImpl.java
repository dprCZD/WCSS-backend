package czd.wcssbackend.web.impl;

import czd.wcssbackend.common.model.systemType.Notice;
import czd.wcssbackend.persistence.mapper.NoticeMapper;
import czd.wcssbackend.web.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName NoticeServiceImpl
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/19 15:02
 */
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper mapper;
    @Override
    public Notice getNotice(Integer noticeId) {
        return mapper.getNotice(noticeId);
    }

    @Override
    public void insertNotice(Notice notice) {
        mapper.insertNotice(notice);
    }

    @Override
    public void updateNotice(Notice notice) {
        mapper.updateNotice(notice);
    }

    @Override
    public void deleteNotice(Integer noticeId) {
        mapper.deleteNotice(noticeId);
    }

    @Override
    public List<Notice> listNotices() {
        return mapper.listNotices();
    }
}
