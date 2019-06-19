package czd.wcssbackend.web.service;

import czd.wcssbackend.common.model.systemType.News;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NewsService {

    News getNews( Integer newsId);

    void insertNews(News news);

    void updateNews( News news);

    void deleteNews(Integer newsId);

    List<News> listNewss();
}
