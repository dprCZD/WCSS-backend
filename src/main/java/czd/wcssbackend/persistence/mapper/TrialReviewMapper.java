package czd.wcssbackend.persistence.mapper;


import czd.wcssbackend.common.model.systemType.TrialReview;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName TrialReviewMapper
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/18 18:25
 */
@Mapper
public interface TrialReviewMapper {

    void insertTrialReview(@Param("trialReview")TrialReview trialReview);

    void updateTrialReview(@Param("trialReview")TrialReview trialReview);

    List<TrialReview> listTrialReviews();

    List<TrialReview> listTrialReviewsByParId(@Param("parId")Integer parId);

    List<TrialReview> listTrialReviewsByCourseId(@Param("courseId")Integer courseId);

    void deleteTrialReview(@Param("reviewId")Integer reviewId);

    TrialReview getTrialReview(@Param("reviewId")Integer reviewId);
}
