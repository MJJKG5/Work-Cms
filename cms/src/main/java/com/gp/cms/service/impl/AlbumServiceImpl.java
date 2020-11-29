package com.gp.cms.service.impl;

import com.gp.cms.common.utils.Check;
import com.gp.cms.model.Album;
import com.gp.cms.model.entity.Page;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.repository.AlbumMapper;
import com.gp.cms.repository.PhotoMapper;
import com.gp.cms.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("albumService")
public class AlbumServiceImpl implements AlbumService {
    @Autowired
    private AlbumMapper albumMapper;
    @Autowired
    private PhotoMapper photoMapper;

    /**
     * 查询相册
     *
     * @param name     相册名
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> queryAlbum(String name, Integer pageNo, Integer pageSize) {
        Check.isNull(pageNo, "pageNo 参数为空");
        Check.isNull(pageNo, "pageSize 参数为空");
        // 查询数量
        Long total = albumMapper.count(name);
        // 分页
        Page page = new Page(pageNo, pageSize, total);
        // 查询相册
        List<Album> albums = albumMapper.queryByList(name, page);

        Map<String, Object> map = new HashMap<>();
        map.put("albums", albums);
        map.put("page", page);
        return new ResApi<>(map);
    }

    /**
     * 新增相册
     *
     * @param album 相册
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> addAlbum(Album album) {
        Check.isNull(album.getName(), "name 参数为空");
        // 新增相册
        albumMapper.add(album);

        return new ResApi<>();
    }

    /**
     * 修改相册
     *
     * @param album 相册
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> updateAlbum(Album album) {
        Check.isNull(album.getId(), "id 参数为空");
        Check.isNull(album.getName(), "name 参数为空");
        // 修改相册
        albumMapper.update(album);

        return new ResApi<>();
    }

    /**
     * 删除相册
     *
     * @param id 相册id
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> deleteAlbum(Long id) {
//        Check.isNull(id, "id 参数为空");
//        // 删除相册
//        albumMapper.delete(id);
//
//        // 查询照片
//        List<Photo> photos = photoMapper.queryByAlbumId(id);
//        if (photos != null && !photos.isEmpty()) {
//            // 删除照片(数据)
//            photoMapper.deleteByAlbumId(id);
//            // 删除照片(文件)
//            photos.forEach(photo -> {
//                FileUtil.del(photo.getOriginUrl());
//            });
//        }
        return new ResApi<>();
    }
}
