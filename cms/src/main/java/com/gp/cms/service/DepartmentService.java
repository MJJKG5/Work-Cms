package com.gp.cms.service;

import com.gp.cms.model.Department;
import com.gp.cms.model.entity.ResApi;

import java.util.Map;

public interface DepartmentService {
    /**
     * 查询院系
     *
     * @param name     名称
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    ResApi<Map<String, Object>> queryDepartment(String name, Integer pageNo, Integer pageSize);

    /**
     * 添加院系
     *
     * @param department 院系
     * @return
     */
    ResApi<String> addDepartment(Department department);

    /**
     * 修改院系
     *
     * @param department 院系
     * @return
     */
    ResApi<String> updateDepartment(Department department);

    /**
     * 删除院系
     *
     * @param id 院系id
     * @return
     */
    ResApi<String> deleteDepartment(Long id);
}
