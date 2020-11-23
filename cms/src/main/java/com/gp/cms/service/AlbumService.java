package com.gp.cms.service;

import com.gp.cms.model.Album;
import com.gp.cms.model.entity.ResApi;

import java.util.Map;

public interface AlbumService {
    /**
     * 查询相册
     *
     * @param name     相册名
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    ResApi<Map<String, Object>> queryAlbum(String name, Integer pageNo, Integer pageSize);

    /**
     * 新增相册
     *
     * @param album 相册
     * @return
     */
    ResApi<String> addAlbum(Album album);

    /**
     * 修改相册
     *
     * @param album 相册
     * @return
     */
    ResApi<String> updateAlbum(Album album);

    /**
     * 删除相册
     *
     * @param id 相册id
     * @return
     */
    ResApi<String> deleteAlbum(Long id);
}
