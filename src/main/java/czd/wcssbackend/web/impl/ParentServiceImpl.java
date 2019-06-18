package czd.wcssbackend.web.impl;

import czd.wcssbackend.common.model.userType.Parent;
import czd.wcssbackend.persistence.mapper.ParentMapper;
import czd.wcssbackend.web.service.ParentService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @ClassName ParentServiceImpl
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:15
 */
public class ParentServiceImpl implements ParentService {
    @Autowired
    ParentMapper mapper;
    @Override
    public Parent getParentByParId(Integer parId) {
        return mapper.getParentByParId(parId);
    }

    @Override
    public Parent getParentByUserId(Integer userId) {
        return mapper.getParentByUserId(userId);
    }

    @Override
    public List<Parent> listParents() {
        return mapper.listParents();
    }

    @Override
    public void updateParentByParId(Parent parent) {
        mapper.updateParentByParId(parent);
    }

    @Override
    public void insertParent(Parent parent) {
        mapper.insertParent(parent);
    }
}
