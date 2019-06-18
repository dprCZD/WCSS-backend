package czd.wcssbackend.persistence.mapper;

import czd.wcssbackend.common.model.userType.Parent;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName ParentMapper
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:05
 */

@Mapper
public interface ParentMapper {
    Parent getParentByParId(@Param("parId")Integer parId);

    Parent getParentByUserId(@Param("userId")Integer userId);

    List<Parent> listParents();

    void updateParentByParId(@Param("parent")Parent parent);

    void insertParent(@Param("parent")Parent parent);
}
