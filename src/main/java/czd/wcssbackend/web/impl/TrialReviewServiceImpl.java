package czd.wcssbackend.web.impl;

import czd.wcssbackend.common.model.systemType.TrialReview;
import czd.wcssbackend.persistence.mapper.TrialReviewMapper;
import czd.wcssbackend.web.service.TrialReviewService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName TrialReviewServiceImpl
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/18 18:46
 */
public class TrialReviewServiceImpl implements TrialReviewService {

    @Autowired
    TrialReviewMapper mapper;
    @Override
    public void insertTrialReview(TrialReview trialReview) {
        mapper.insertTrialReview(trialReview);
    }

    @Override
    public void updateTrialReview(TrialReview trialReview) {
        mapper.updateTrialReview(trialReview);
    }

    @Override
    public List<TrialReview> listTrialReviews() {
        return mapper.listTrialReviews();
    }

    @Override
    public List<TrialReview> listTrialReviewsByParId(Integer parId) {
        return mapper.listTrialReviewsByParId(parId);
    }

    @Override
    public List<TrialReview> listTrialReviewsByCourseId(Integer courseId) {
        return mapper.listTrialReviewsByCourseId(courseId);
    }

    @Override
    public void deleteTrialReview(Integer reviewId) {
        mapper.deleteTrialReview(reviewId);
    }

    @Override
    public TrialReview getTrialReview(Integer reviewId) {
        return mapper.getTrialReview(reviewId);
    }
}
