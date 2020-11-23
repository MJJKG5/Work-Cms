package com.gp.cms.repository;

import com.gp.cms.model.Album;
import com.gp.cms.model.entity.Page;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlbumMapper {
    /**
     * 查询
     *
     * @param name 相册名
     * @param page 分页
     * @return
     */
    List<Album> queryByList(@Param("name") String name, @Param("page") Page page);

    /**
     * 添加
     *
     * @param album 相册
     */
    void add(@Param("album") Album album);

    /**
     * 修改
     *
     * @param album 相册
     */
    void update(@Param("album") Album album);

    /**
     * 删除
     *
     * @param id 相册id
     */
    void delete(Long id);

    /**
     * 查询数量
     *
     * @param name 相册名
     * @return
     */
    Long count(String name);
}
