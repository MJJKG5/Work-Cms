package com.gp.cms.service.impl;

import com.gp.cms.common.exception.LogicException;
import com.gp.cms.common.utils.Check;
import com.gp.cms.common.utils.Session;
import com.gp.cms.model.Student;
import com.gp.cms.model.entity.Page;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.repository.MessageMapper;
import com.gp.cms.repository.StudentMapper;
import com.gp.cms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("studentService")
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private MessageMapper messageMapper;

    /**
     * 查询学生
     *
     * @param name     姓名
     * @param classId  班级id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    public ResApi<Map<String, Object>> queryStudent(String name, Long classId, Integer pageNo, Integer pageSize) {
        Check.isNull(pageNo, "pageNo 参数为空");
        Check.isNull(pageSize, "pageSize 参数为空");
        // 查询数量
        Long total = studentMapper.count(name, classId);
        // 分页
        Page page = new Page(pageNo, pageSize, total);
        // 查询学生
        List<Student> students = studentMapper.queryByList(name, classId, page);

        Map<String, Object> map = new HashMap<>();
        map.put("students", students);
        map.put("page", page);
        return new ResApi<>(map);
    }

    /**
     * 修改学生
     *
     * @param student 学生
     * @param request 请求
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> updateStudent(Student student, HttpServletRequest request) {
        Check.isNull(student.getId(), "id 参数为空");
        Check.isNull(student.getName(), "name 参数为空");
        Check.isNull(student.getSex(), "sex; 参数为空");
        Check.isNull(student.getAge(), "age 参数为空");
        Check.isNull(student.getClassId(), "classId 参数为空");
        // 查询学生
        Student result = studentMapper.queryById(student.getId());
        if (result != null) {
            if (!StringUtils.isEmpty(student.getEmail()) && !student.getEmail().equals(result.getEmail())) {
                // 验证 Email
                Student email = studentMapper.queryByEmail(student.getEmail());
                if (email != null) {
                    throw new LogicException("Email 已注册");
                } else {
                    Check.isNull(student.getCode(), "code 参数为空");
                    // 检测验证码
                    String code = new Session(request).code();
                    if (!code.equals(student.getCode())) {
                        throw new LogicException("验证码错误");
                    }
                }
            }

            // 修改学生
            studentMapper.update(student);
        }

        return new ResApi<>();
    }

    /**
     * 删除学生
     *
     * @param id 学生id
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> deleteStudent(Long id) {
        Check.isNull(id, "id 参数为空");
        // 查询学生
        Student student = studentMapper.queryById(id);
        if (student != null) {
            // 删除学生
            studentMapper.delete(id);
            // 删除留言
            messageMapper.deleteByFromOrTo(student.getId());
        }

        return new ResApi<>();
    }
}
