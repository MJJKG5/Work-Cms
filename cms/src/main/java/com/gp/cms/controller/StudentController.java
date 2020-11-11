package com.gp.cms.controller;

import com.gp.cms.model.Student;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RestController
@RequestMapping("api")
public class StudentController {
    @Autowired
    private StudentService studentService;

    /**
     * 查询学生
     *
     * @param name     姓名
     * @param classId  班级id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "student", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryStudent(@RequestParam(required = false) String name,
                                                    @RequestParam(required = false) Long classId,
                                                    @RequestParam Integer pageNo,
                                                    @RequestParam Integer pageSize) {
        return studentService.queryStudent(name, classId, pageNo, pageSize);
    }

    /**
     * 修改学生
     *
     * @param student 学生
     * @param request 请求
     * @return
     */
    @RequestMapping(value = "student", method = RequestMethod.PUT)
    public ResApi<String> updateStudent(@RequestBody Student student, HttpServletRequest request) {
        return studentService.updateStudent(student, request);
    }

    /**
     * 删除学生
     *
     * @param id 学生id
     * @return
     */
    @RequestMapping(value = "student", method = RequestMethod.DELETE)
    public ResApi<String> deleteStudent(@RequestParam Long id) {
        return studentService.deleteStudent(id);
    }
}
