package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.systemType.News;

import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.controller.pojo.NewsCreateConfig;
import czd.wcssbackend.web.service.NewsService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName NewsController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/19 15:04
 */
@Api(value = "NewsController", description = "新闻操作")
@RestController
@RequestMapping("/api/v1")
public class NewsController {

    private static final Logger logger = LoggerFactory.getLogger(NewsController.class);

    @Autowired
    NewsService service;

    @ApiOperation(value = "获取公告", notes = "获取公告", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "newsId", value = "newsId", dataType = "integer", paramType = "path"),
    })
    @RequestMapping(value = "/news/{newsId}", method = RequestMethod.GET,produces = "application/json")
    public News getNews(@PathVariable("newsId")String newsId){
        int id=-1;
        try{
            id=Integer.valueOf(newsId);
        } catch (NumberFormatException e)
        {

        }
        News bean=null;
        if(id!=-1)
            bean=service.getNews(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该公告信息！").getMessage()); ;
        }
        logger.info("get News success:"+newsId);
        return bean;
    }




    @ApiOperation(value = "获取公告列表", notes = "获取公告列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "", dataType = "keyword", paramType = "query"),
    })
    @RequestMapping(value = "/news", method = RequestMethod.GET,produces = "application/json")
    public List<News> listNewss(@RequestParam(value = "keyword", required = false,defaultValue = "")String keyword)
    {
        return service.listNewss();
    }



    @ApiOperation(value = "更新公告", notes = "公告", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "news", value = "news", dataType = "News", paramType = "body"),
    })
    @RequestMapping(value = "/news", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateNews(@RequestBody News news)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.updateNews(news);
        }
        catch ( Exception e)
        {
            logger.error("update News failure:"+messageBox.getMessage());
            messageBox.setStatus(MessageBox.UPDATE_NEWS_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_NEWS_SUCCESS_CODE);
        messageBox.setMessage("update News success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "删除公告", notes = "删除公告", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "newsId", value = "newsId", dataType = "integer", paramType = "path"),
    })
    @RequestMapping(value = "/news/{newsId}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteNews(@PathVariable("newsId")Integer newsId)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.deleteNews(newsId);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_NEWS_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_NEWS_SUCCESS_CODE);
        messageBox.setMessage("delete News success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "插入公告", notes = "插入公告", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "config", dataType = "NewsCreateConfig", paramType = "body"),
    })
    @RequestMapping(value = "/news", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertNews(@RequestBody NewsCreateConfig config)
    {
        News news=createNewsByConfig(config);
        MessageBox messageBox=new MessageBox();
        try{
            service.insertNews(news);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_NEWS_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_NEWS_SUCCESS_CODE);
        messageBox.setMessage("insert News success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    private News createNewsByConfig(NewsCreateConfig config)
    {
        News news=new News();
        news.setNewsResource(config.getNewsResource());
        news.setNewsTime(config.getNewsTime());
        news.setNewsWords(config.getNewsWords());
        news.setUserId(config.getUserId());
        return news;
    }
}
