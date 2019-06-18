package czd.wcssbackend.web.impl;


import czd.wcssbackend.common.model.userType.EduIns;
import czd.wcssbackend.persistence.mapper.EduInsMapper;
import czd.wcssbackend.web.service.EduInsService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName ParentServiceImpl
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:15
 */
public class EduInsServiceImpl implements EduInsService {

    @Autowired
    EduInsMapper mapper;
    @Override
    public EduIns getEduInsByEduId(Integer eduId) {
        return mapper.getEduInsByEduId(eduId);
    }

    @Override
    public EduIns getEduInsByUserId(Integer userId) {
        return mapper.getEduInsByUserId(userId);
    }

    @Override
    public List<EduIns> listEduInss() {
        return mapper.listEduInss();
    }

    @Override
    public void updateEduInsByEduId(EduIns eduIns) {
        mapper.updateEduInsByEduId(eduIns);
    }

    @Override
    public void insertEduIns(EduIns eduIns) {
        mapper.insertEduIns(eduIns);
    }
}
