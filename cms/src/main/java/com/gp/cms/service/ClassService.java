package com.gp.cms.service;

import com.gp.cms.model.Class;
import com.gp.cms.model.entity.ResApi;

import java.util.Map;

public interface ClassService {
    /**
     * 查询班级
     *
     * @param name         名称
     * @param departmentId 院系id
     * @param pageNo       页码
     * @param pageSize     页大小
     * @return
     */
    ResApi<Map<String, Object>> queryClass(String name, Long departmentId, Integer pageNo, Integer pageSize);

    /**
     * 新增班级
     *
     * @param clazz 班级
     * @return
     */
    ResApi<String> addClass(Class clazz);

    /**
     * 修改班级
     *
     * @param clazz 班级
     * @return
     */
    ResApi<String> updateClass(Class clazz);

    /**
     * 删除班级
     *
     * @param id 班级id
     * @return
     */
    ResApi<String> deleteClass(Long id);
}
