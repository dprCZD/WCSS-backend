package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.systemType.Notice;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.controller.pojo.NoticeCreateConfig;
import czd.wcssbackend.web.service.NoticeService;
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
 * @ClassName NoticeController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/19 15:04
 */
@Api(value = "NoticeController", description = "公告操作")
@RestController
@RequestMapping("/api/v1")
public class NoticeController {

    private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

    @Autowired
    NoticeService service;

    @ApiOperation(value = "获取公告", notes = "获取公告", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeId", value = "noticeId", dataType = "integer", paramType = "path"),
    })
    @RequestMapping(value = "/notice/{noticeId}", method = RequestMethod.GET,produces = "application/json")
    public Notice getNotice(@PathVariable("noticeId")String noticeId){
        int id=-1;
        try{
            id=Integer.valueOf(noticeId);
        } catch (NumberFormatException e)
        {

        }
        Notice bean=null;
        if(id!=-1)
            bean=service.getNotice(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该公告信息！").getMessage()); ;
        }
        logger.info("get Notice success:"+noticeId);
        return bean;
    }




    @ApiOperation(value = "获取公告列表", notes = "获取公告列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "keyword", value = "", dataType = "keyword", paramType = "query"),
    })
    @RequestMapping(value = "/notice", method = RequestMethod.GET,produces = "application/json")
    public List<Notice> listNotices(@RequestParam(value = "keyword", required = false,defaultValue = "")String keyword)
    {
        return service.listNotices();
    }



    @ApiOperation(value = "更新公告", notes = "公告", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "notice", value = "notice", dataType = "Notice", paramType = "body"),
    })
    @RequestMapping(value = "/notice", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateNotice(@RequestBody Notice notice)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.updateNotice(notice);
        }
        catch ( Exception e)
        {
            logger.error("update Notice failure:"+messageBox.getMessage());
            messageBox.setStatus(MessageBox.UPDATE_NOTICE_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_NOTICE_SUCCESS_CODE);
        messageBox.setMessage("update Notice success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "删除公告", notes = "删除公告", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "noticeId", value = "noticeId", dataType = "integer", paramType = "path"),
    })
    @RequestMapping(value = "/notice/{noticeId}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteNotice(@PathVariable("noticeId")Integer noticeId)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.deleteNotice(noticeId);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_NOTICE_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_NOTICE_SUCCESS_CODE);
        messageBox.setMessage("delete Notice success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "插入公告", notes = "插入公告", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "config", dataType = "NoticeCreateConfig", paramType = "body"),
    })
    @RequestMapping(value = "/notice", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertNotice(@RequestBody NoticeCreateConfig config)
    {
        Notice notice=createNoticeByConfig(config);
        MessageBox messageBox=new MessageBox();
        try{
            service.insertNotice(notice);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_NOTICE_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_NOTICE_SUCCESS_CODE);
        messageBox.setMessage("insert Notice success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    private Notice createNoticeByConfig(NoticeCreateConfig config)
    {
        Notice notice=new Notice();
        notice.setNoticePic(config.getNoticePic());
        notice.setTeacherId(config.getTeacherId());
        notice.setNoticeTime(config.getNoticeTime());
        notice.setNoticeWords(config.getNoticeWords());
        return notice;
    }
}
