package com.gp.cms.controller;

import com.gp.cms.model.Class;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.service.ClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api")
public class ClassController {
    @Autowired
    private ClassService classService;

    /**
     * 查询班级
     *
     * @param name         名称
     * @param departmentId 院系id
     * @param pageNo       页码
     * @param pageSize     页大小
     * @return
     */
    @RequestMapping(value = "class", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryClass(@RequestParam(required = false) String name,
                                                  @RequestParam(required = false) Long departmentId,
                                                  @RequestParam Integer pageNo,
                                                  @RequestParam Integer pageSize) {
        return classService.queryClass(name, departmentId, pageNo, pageSize);
    }

    /**
     * 新增班级
     *
     * @param clazz 班级
     * @return
     */
    @RequestMapping(value = "class", method = RequestMethod.POST)
    public ResApi<String> addClass(@RequestBody Class clazz) {
        return classService.addClass(clazz);
    }

    /**
     * 修改班级
     *
     * @param clazz 班级
     * @return
     */
    @RequestMapping(value = "class", method = RequestMethod.PUT)
    public ResApi<String> updateClass(@RequestBody Class clazz) {
        return classService.updateClass(clazz);
    }

    /**
     * 删除班级
     *
     * @param id 班级id
     * @return
     */
    @RequestMapping(value = "class", method = RequestMethod.DELETE)
    public ResApi<String> deleteClass(@RequestParam Long id) {
        return classService.deleteClass(id);
    }
}
