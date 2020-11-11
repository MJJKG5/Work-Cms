package com.gp.cms.repository;

import com.gp.cms.model.Student;
import com.gp.cms.model.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentMapper {
    /**
     * 查询
     *
     * @param name    姓名
     * @param classId 班级id
     * @param page    分页
     * @return
     */
    List<Student> queryByList(@Param("name") String name, @Param("classId") Long classId, @Param("page") Page page);

    /**
     * 查询
     *
     * @param email 邮件
     * @return
     */
    Student queryByEmail(String email);

    /**
     * 查询
     *
     * @param id 学生id
     * @return
     */
    Student queryById(Long id);

    /**
     * 添加
     *
     * @param student 学生
     */
    void add(@Param("student") Student student);

    /**
     * 修改
     *
     * @param student 学生
     */
    void update(@Param("student") Student student);

    /**
     * 修改
     *
     * @param id       学生id
     * @param password 密码
     */
    void updateById(@Param("id") Long id, @Param("password") String password);

    /**
     * 修改
     *
     * @param email    邮件
     * @param password 密码
     */
    void updateByEmail(@Param("email") String email, @Param("password") String password);

    /**
     * 删除
     *
     * @param id 学生id
     */
    void delete(Long id);

    /**
     * 查询数量
     *
     * @param name    姓名
     * @param classId 班级id
     * @return
     */
    Long count(@Param("name") String name, @Param("classId") Long classId);
}
