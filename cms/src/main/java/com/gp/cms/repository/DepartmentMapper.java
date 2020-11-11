package com.gp.cms.repository;

import com.gp.cms.model.Department;
import com.gp.cms.model.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DepartmentMapper {
    /**
     * 查询
     *
     * @param name 名称
     * @param page 分页
     * @return
     */
    List<Department> queryByList(@Param("name") String name, @Param("page") Page page);

    /**
     * 查询
     *
     * @param name 名称
     * @return
     */
    Department queryByName(String name);

    /**
     * 添加
     *
     * @param department 院系
     */
    void add(@Param("department") Department department);

    /**
     * 修改
     *
     * @param department 院系
     */
    void update(@Param("department") Department department);

    /**
     * 删除
     *
     * @param id 院系id
     */
    void delete(Long id);

    /**
     * 查询数量
     *
     * @param name 名称
     * @return
     */
    Long count(String name);
}
