package com.gp.cms.controller;

import com.gp.cms.model.Department;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    /**
     * 查询院系
     *
     * @param name     名称
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "department", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryDepartment(@RequestParam(required = false) String name,
                                                       @RequestParam Integer pageNo,
                                                       @RequestParam Integer pageSize) {
        return departmentService.queryDepartment(name, pageNo, pageSize);
    }

    /**
     * 添加院系
     *
     * @param department 院系
     * @return
     */
    @RequestMapping(value = "department", method = RequestMethod.POST)
    public ResApi<String> addDepartment(@RequestBody Department department) {
        return departmentService.addDepartment(department);
    }

    /**
     * 修改院系
     *
     * @param department 院系
     * @return
     */
    @RequestMapping(value = "department", method = RequestMethod.PUT)
    public ResApi<String> updateDepartment(@RequestBody Department department) {
        return departmentService.updateDepartment(department);
    }

    /**
     * 删除院系
     *
     * @param id 院系id
     * @return
     */
    @RequestMapping(value = "department", method = RequestMethod.DELETE)
    public ResApi<String> deleteDepartment(@RequestParam Long id) {
        return departmentService.deleteDepartment(id);
    }
}
