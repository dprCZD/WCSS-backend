package czd.wcssbackend.web.impl;

import czd.wcssbackend.common.model.systemType.News;
import czd.wcssbackend.persistence.mapper.NewsMapper;
import czd.wcssbackend.web.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName NewsServiceImpl
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/19 15:40
 */
public class NewsServiceImpl implements NewsService {

    @Autowired
    NewsMapper mapper;
    @Override
    public News getNews(Integer newsId) {
        return mapper.getNews(newsId);
    }

    @Override
    public void insertNews(News news) {
        mapper.insertNews(news);
    }

    @Override
    public void updateNews(News news) {
        mapper.updateNews(news);
    }

    @Override
    public void deleteNews(Integer newsId) {
        mapper.deleteNews(newsId);
    }

    @Override
    public List<News> listNewss() {
        return mapper.listNewss();
    }
}
