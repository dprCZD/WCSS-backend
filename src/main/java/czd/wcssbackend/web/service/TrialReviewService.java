package czd.wcssbackend.web.service;

import czd.wcssbackend.common.model.systemType.TrialReview;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrialReviewService {
    void insertTrialReview(TrialReview trialReview);

    void updateTrialReview(TrialReview trialReview);

    List<TrialReview> listTrialReviews();

    List<TrialReview> listTrialReviewsByParId(Integer parId);

    List<TrialReview> listTrialReviewsByCourseId(Integer courseId);

    void deleteTrialReview(Integer reviewId);

    TrialReview getTrialReview(Integer reviewId);
}
