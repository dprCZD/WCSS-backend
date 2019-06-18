package czd.wcssbackend.persistence.mapper;

import czd.wcssbackend.common.model.userType.EduIns;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @ClassName EduInsMapper
 * @Description TODO
 * @Author dprCZD
 * @Date 2019/6/12 17:05
 */

@Mapper
public interface EduInsMapper {
    EduIns getEduInsByEduId(@Param("eduId") Integer eduId);

    EduIns getEduInsByUserId(@Param("userId") Integer userId);

    List<EduIns> listEduInss();

    void updateEduInsByEduId(@Param("eduIns") EduIns eduIns);

    void insertEduIns(@Param("eduIns") EduIns eduIns);
}
