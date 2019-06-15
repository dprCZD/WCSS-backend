package czd.wcssbackend.web.service;

import czd.wcssbackend.common.model.EduIns;
import czd.wcssbackend.common.model.Parent;

import java.util.List;

/**
 * @ClassName ParentService
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:12
 */
public interface EduInsService {

    EduIns getEduInsByEduId( Integer eduId);

    EduIns getEduInsByUserId(Integer userId);

    List<EduIns> listEduInss();

    void updateEduInsByEduId( EduIns eduIns);

    void insertEduIns( EduIns eduIns);
}
