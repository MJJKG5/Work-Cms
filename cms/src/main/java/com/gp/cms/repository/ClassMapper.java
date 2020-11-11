package com.gp.cms.repository;

import com.gp.cms.model.Class;
import com.gp.cms.model.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClassMapper {
    /**
     * 查询
     *
     * @param name         名称
     * @param departmentId 院系id
     * @return
     */
    List<Class> queryByList(@Param("name") String name,
                            @Param("departmentId") Long departmentId,
                            @Param("page") Page page);

    /**
     * 查询
     *
     * @param name         名称
     * @param departmentId 院系id
     * @return
     */
    Class queryByName(@Param("name") String name, @Param("departmentId") Long departmentId);

    /**
     * 添加
     *
     * @param clazz 班级
     */
    void add(@Param("class") Class clazz);

    /**
     * 修改
     *
     * @param clazz 班级
     */
    void update(@Param("class") Class clazz);

    /**
     * 删除
     *
     * @param id 班级id
     */
    void delete(Long id);

    /**
     * 查询数量
     *
     * @param name         名称
     * @param departmentId 院系id
     * @return
     */
    Long count(@Param("name") String name, @Param("departmentId") Long departmentId);
}
