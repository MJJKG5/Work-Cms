package com.gp.cms.service;

import com.gp.cms.model.Student;
import com.gp.cms.model.entity.ResApi;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public interface StudentService {
    /**
     * 查询学生
     *
     * @param name     姓名
     * @param classId  班级id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    ResApi<Map<String, Object>> queryStudent(String name, Long classId, Integer pageNo, Integer pageSize);

    /**
     * 修改学生
     *
     * @param student 学生
     * @param request 请求
     * @return
     */
    ResApi<String> updateStudent(Student student, HttpServletRequest request);

    /**
     * 删除学生
     *
     * @param id 学生id
     * @return
     */
    ResApi<String> deleteStudent(Long id);
}
