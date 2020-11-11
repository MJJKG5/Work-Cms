package com.gp.cms.service.impl;

import com.gp.cms.common.exception.LogicException;
import com.gp.cms.common.utils.Check;
import com.gp.cms.model.Class;
import com.gp.cms.model.entity.Page;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.repository.ClassMapper;
import com.gp.cms.repository.StudentMapper;
import com.gp.cms.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("classService")
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassMapper classMapper;

    /**
     * 查询班级
     *
     * @param name         名称
     * @param departmentId 院系id
     * @param pageNo       页码
     * @param pageSize     页大小
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> queryClass(String name, Long departmentId, Integer pageNo, Integer pageSize) {
        Check.isNull(pageNo, "pageNo参数为空");
        Check.isNull(pageSize, "pageSize参数为空");
        // 查询数量
        Long total = classMapper.count(name, departmentId);
        // 分页
        Page page = new Page(pageNo, pageSize, total);
        // 查询班级
        List<Class> classes = classMapper.queryByList(name, departmentId, page);

        Map<String, Object> map = new HashMap<>();
        map.put("classes", classes);
        map.put("page", page);
        return new ResApi<>(map);
    }

    /**
     * 新增班级
     *
     * @param clazz 班级
     * @return
     */
    @Override
    public ResApi<String> addClass(Class clazz) {
        Check.isNull(clazz.getName(), "name 参数为空");
        Check.isNull(clazz.getDepartmentId(), "departmentId 参数为空");
        // 验证班级
        Class result = classMapper.queryByName(clazz.getName(), clazz.getDepartmentId());
        if (null != result) {
            throw new LogicException("名称已使用");
        }
        // 新增班级
        classMapper.add(clazz);

        return new ResApi<>();
    }

    /**
     * 修改班级
     *
     * @param clazz 班级
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> updateClass(Class clazz) {
        Check.isNull(clazz.getId(), "id 参数为空");
        Check.isNull(clazz.getName(), "name 参数为空");
        Check.isNull(clazz.getDepartmentId(), "departmentId 参数为空");
        // 验证班级
        Class result = classMapper.queryByName(clazz.getName(), clazz.getDepartmentId());
        if (null != result) {
            if (result.getId().equals(clazz.getId())) {
                throw new LogicException("名称已使用");
            }
        }
        // 修改班级
        classMapper.update(clazz);

        return new ResApi<>();
    }

    /**
     * 删除班级
     *
     * @param id 班级id
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> deleteClass(Long id) {
        Check.isNull(id, "id 参数为空");
        // 删除班级
        classMapper.delete(id);

        return new ResApi<>();
    }
}
