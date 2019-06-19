package czd.wcssbackend.persistence.mapper;


import czd.wcssbackend.common.model.systemType.News;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface NewsMapper {
        News getNews(@Param("newsId") Integer newsId);

        void insertNews(@Param("news") News news);

        void updateNews(@Param("news") News news);

        void deleteNews(@Param("newsId") Integer newsId);

        List<News> listNewss();

}
