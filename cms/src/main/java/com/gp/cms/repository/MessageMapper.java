package com.gp.cms.repository;

import com.gp.cms.model.Message;
import com.gp.cms.model.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageMapper {
    /**
     * 查询
     *
     * @param to   收件人
     * @param page 分页
     * @return
     */
    List<Message> queryByList(@Param("to") Long to, @Param("page") Page page);

    /**
     * 添加
     *
     * @param message 留言
     */
    void add(@Param("message") Message message);

    /**
     * 删除
     *
     * @param id 留言id
     */
    void delete(Long id);

    /**
     * 删除
     *
     * @param to 收件人id
     */
    void deleteByTo(Long to);

    /**
     * 查询数量
     *
     * @param to 收件人
     * @return
     */
    Long count(Long to);
}
