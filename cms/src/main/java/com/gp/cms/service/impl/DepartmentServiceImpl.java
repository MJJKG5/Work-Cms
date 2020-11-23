package com.gp.cms.service.impl;

import com.gp.cms.common.exception.LogicException;
import com.gp.cms.common.utils.Check;
import com.gp.cms.model.Department;
import com.gp.cms.model.entity.Page;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.repository.DepartmentMapper;
import com.gp.cms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    private DepartmentMapper departmentMapper;

    /**
     * 查询院系
     *
     * @param name     名称
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> queryDepartment(String name, Integer pageNo, Integer pageSize) {
        Check.isNull(pageNo, "pageNo 参数为空");
        Check.isNull(pageSize, "pageSize 参数为空");
        // 查询数量
        Long total = departmentMapper.count(name);
        // 分页
        Page page = new Page(pageNo, pageSize, total);
        // 查询院系
        List<Department> departments = departmentMapper.queryByList(name, page);

        Map<String, Object> map = new HashMap<>();
        map.put("departments", departments);
        map.put("page", page);
        return new ResApi<>(map);
    }

    /**
     * 添加院系
     *
     * @param department 院系
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> addDepartment(Department department) {
        Check.isNull(department.getName(), "name 参数为空");
        // 验证院系
        Department result = departmentMapper.queryByName(department.getName());
        if (result != null) {
            throw new LogicException("名称已使用");
        }
        // 新增院系
        departmentMapper.add(department);

        return new ResApi<>();
    }

    /**
     * 修改院系
     *
     * @param department 院系
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> updateDepartment(Department department) {
        Check.isNull(department.getId(), "id 参数为空");
        Check.isNull(department.getName(), "name 参数为空");
        // 验证院系
        Department result = departmentMapper.queryByName(department.getName());
        if (result != null) {
            if (result.getId().equals(department.getId())) {
                throw new LogicException("名称已使用");
            }
        }
        // 修改院系
        departmentMapper.update(department);

        return new ResApi<>();
    }

    /**
     * 删除院系
     *
     * @param id 院系id
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> deleteDepartment(Long id) {
        Check.isNull(id, "id 参数为空");
        // 删除院系
        departmentMapper.delete(id);

        return new ResApi<>();
    }
}
