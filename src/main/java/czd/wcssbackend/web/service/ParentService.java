package czd.wcssbackend.web.service;

import czd.wcssbackend.common.model.Parent;

import java.util.List;

/**
 * @ClassName ParentService
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:12
 */
public interface ParentService {

    Parent getParentByParId(Integer parId);

    Parent getParentByUserId(Integer userId);

    List<Parent> listParents();

    void updateParentByParId(Parent parent);

    void insertParent(Parent parent);
}
