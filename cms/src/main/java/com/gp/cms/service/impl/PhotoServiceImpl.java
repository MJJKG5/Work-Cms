package com.gp.cms.service.impl;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.gp.cms.common.utils.Check;
import com.gp.cms.model.Photo;
import com.gp.cms.model.entity.Page;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.repository.PhotoMapper;
import com.gp.cms.service.PhotoService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("photoService")
public class PhotoServiceImpl implements PhotoService {
    private static final Logger logger = LogManager.getLogger();
    @Value("${photo.proxy}")
    private String proxy;
    @Value("${photo.file}")
    private String origin;

    @Autowired
    private PhotoMapper photoMapper;

    /**
     * 查询照片
     *
     * @param classId  班级id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @Override
    public ResApi<Map<String, Object>> queryPhoto(Long classId, Integer pageNo, Integer pageSize) {
        Check.isNull(classId, "classId 参数为空");
        Check.isNull(pageNo, "pageNo 参数为空");
        Check.isNull(pageSize, "pageSize 参数为空");
        // 查询数量
        Long total = photoMapper.count(classId);
        // 分页
        Page page = new Page(pageNo, pageSize, total);
        // 查询照片
        List<Photo> photos = photoMapper.queryByList(classId, page);

        Map<String, Object> map = new HashMap<>();
        map.put("photos", photos);
        map.put("page", page);
        return new ResApi<>(map);
    }

    /**
     * 上传照片
     *
     * @param file    文件
     * @param classId 班级id
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> uploadPhoto(MultipartFile file, Long classId) {
        Check.isNull(file, "file 参数为空");
        Check.isNull(classId, "classId 参数为空");
        // 文件名
        String name = file.getOriginalFilename();
        if (name != null) {
            // 下标
            int index = name.indexOf(".");
            // 获取文件后缀
            String suffix = file.getOriginalFilename().substring(index);
            // 拼接文件名
            name = IdUtil.objectId() + suffix;

            // 代理地址
            String proxyUrl = proxy + name;
            // 源文件地址
            String originUrl = origin + name;

            // 上传封面
            try {
                file.transferTo(new File(originUrl));
            } catch (IOException e) {
                e.printStackTrace();
            }

            // 存储照片
            Photo photo = new Photo();
            // 班级id
            photo.setClassId(classId);
            // 代理地址
            photo.setProxyUrl(proxyUrl);
            // 源文件地址
            photo.setOriginUrl(originUrl);
            photoMapper.add(photo);
        }

        return new ResApi<>();
    }

    /**
     * 删除照片
     *
     * @param id 照片id集合
     * @return
     */
    @Transactional
    @Override
    public ResApi<String> deletePhoto(String id) {
        Check.isNull(id, "id 参数为空");
        // 获取照片id
        List<String> ids = Arrays.asList(id.split(","));
        if (!ids.isEmpty()) {
            // 查询照片
            List<Photo> photos = photoMapper.queryByIds(ids);
            if (photos != null && !photos.isEmpty()) {
                // 删除照片(数据)
                photoMapper.deleteByIds(ids);
                // 删除照片(文件)
                photos.forEach(photo -> {
                    FileUtil.del(photo.getOriginUrl());
                });
            }
        }

        return new ResApi<>();
    }
}
