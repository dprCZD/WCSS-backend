package czd.wcssbackend.persistence.mapper;


import czd.wcssbackend.common.model.systemType.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NoticeMapper {
        Notice getNotice(@Param("noticeId")Integer noticeId);

        void insertNotice(@Param("notice")Notice notice);

        void updateNotice(@Param("notice")Notice notice);

        void deleteNotice(@Param("noticeId")Integer noticeId);

        List<Notice> listNotices();

}
