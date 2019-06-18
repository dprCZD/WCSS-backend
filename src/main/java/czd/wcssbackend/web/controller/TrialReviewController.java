package czd.wcssbackend.web.controller;

import czd.wcssbackend.common.model.systemType.TrialReview;
import czd.wcssbackend.web.controller.pojo.MessageBox;
import czd.wcssbackend.web.controller.pojo.TrialReviewCreateConfig;
import czd.wcssbackend.web.service.TrialReviewService;
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
 * @ClassName TrialReviewController
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/18 19:00
 */

@Api(value = "TrialReviewcontroller", description = "购物车操作")
@RestController
@RequestMapping("/api/v1")
public class TrialReviewController {


    private static final Logger logger = LoggerFactory.getLogger(TrialReviewController.class);

    @Autowired
    TrialReviewService service;

    @ApiOperation(value = "获取试听评价", notes = "获取试听评价", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reviewId", value = "reviewId", dataType = "integer", paramType = "path"),
    })
    @RequestMapping(value = "/review/{reviewId}", method = RequestMethod.GET,produces = "application/json")
    public TrialReview getTrialReview(@PathVariable("reviewId")String reviewId){
        int id=-1;
        try{
            id=Integer.valueOf(reviewId);
        } catch (NumberFormatException e)
        {

        }
        TrialReview bean=null;
        if(id!=-1)
            bean=service.getTrialReview(id);
        if(bean==null)
        {
            logger.error(new UsernameNotFoundException("找不到该试听评价信息！").getMessage()); ;
        }
        logger.info("get TrialReview success:"+reviewId);
        return bean;
    }




    @ApiOperation(value = "通过家长ID获取试听评价列表", notes = "通过家长ID获取试听评价列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "parId", value = "", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "/review/par", method = RequestMethod.GET,produces = "application/json")
    public List<TrialReview> listTrialReviewsByParId(@RequestParam(value = "parId")Integer parId)
    {
        return service.listTrialReviewsByParId(parId);
    }

    @ApiOperation(value = "通过课程ID获取试听评价列表", notes = "通过课程ID获取试听评价列表", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "courseId", value = "", dataType = "Integer", paramType = "query"),
    })
    @RequestMapping(value = "/review/course", method = RequestMethod.GET,produces = "application/json")
    public List<TrialReview> listTrialReviewsByCourseId(@RequestParam(value = "courseId")Integer courseId)
    {
        return service.listTrialReviewsByCourseId(courseId);
    }



    @ApiOperation(value = "更新试听评价", notes = "试听评价", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "trialReview", value = "trialReview", dataType = "TrialReview", paramType = "body"),
    })
    @RequestMapping(value = "/review", method = RequestMethod.PUT,produces = "application/json")
    public MessageBox updateTrialReview(@RequestBody TrialReview trialReview)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.updateTrialReview(trialReview);
        }
        catch ( Exception e)
        {
            logger.error("update TrialReview failure:"+messageBox.getMessage());
            messageBox.setStatus(MessageBox.UPDATE_REVIEW_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.UPDATE_REVIEW_SUCCESS_CODE);
        messageBox.setMessage("update TrialReview success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "删除试听评价", notes = "删除试听评价", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "reviewId", value = "reviewId", dataType = "integer", paramType = "path"),
    })
    @RequestMapping(value = "/review/{reviewId}", method = RequestMethod.DELETE,produces = "application/json")
    public MessageBox deleteTrialReview(@PathVariable("reviewId")Integer reviewId)
    {
        MessageBox messageBox=new MessageBox();
        try{
            service.deleteTrialReview(reviewId);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.DELETE_REVIEW_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.DELETE_REVIEW_SUCCESS_CODE);
        messageBox.setMessage("delete TrialReview success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    @ApiOperation(value = "插入试听评价", notes = "插入试听评价", produces = "application/json")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "config", value = "config", dataType = "TrialReviewCreateConfig", paramType = "body"),
    })
    @RequestMapping(value = "/review", method = RequestMethod.POST,produces = "application/json")
    public MessageBox insertTrialReview(@RequestBody TrialReviewCreateConfig config)
    {
        TrialReview trialReview=createTrialReviewByConfig(config);
        MessageBox messageBox=new MessageBox();
        try{
            service.insertTrialReview(trialReview);
        }
        catch ( Exception e)
        {
            messageBox.setStatus(MessageBox.INSERT_REVIEW_FAILURE_CODE);
            messageBox.setMessage(e.getMessage());
            logger.error(messageBox.getMessage());
            return messageBox;
        }
        messageBox.setStatus(MessageBox.INSERT_REVIEW_SUCCESS_CODE);
        messageBox.setMessage("insert TrialReview success");
        logger.info(messageBox.getMessage());
        return messageBox;
    }

    private TrialReview createTrialReviewByConfig(TrialReviewCreateConfig config)
    {
        TrialReview review=new TrialReview();
        review.setCourseId(config.getCourseId());
        review.setParId(config.getParId());
        review.setReviewCourse(config.getReviewCourse());
        review.setReviewPic(config.getReviewPic());
        review.setReviewStars(config.getReviewStars());
        review.setReviewTeacher(config.getReviewTeacher());
        review.setReviewWords(config.getReviewWords());
        review.setTrialId(config.getTrialId());
        return review;
    }
}
