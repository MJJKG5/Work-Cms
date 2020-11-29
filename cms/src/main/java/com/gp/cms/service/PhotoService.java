package com.gp.cms.service;

import com.gp.cms.model.entity.ResApi;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface PhotoService {
    /**
     * 查询照片
     *
     * @param classId  班级id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    ResApi<Map<String, Object>> queryPhoto(Long classId, Integer pageNo, Integer pageSize);

    /**
     * 上传照片
     *
     * @param file    文件
     * @param albumId 相册id
     * @return
     */
    ResApi<String> uploadPhoto(MultipartFile file, Long albumId);

    /**
     * 删除照片
     *
     * @param id 照片id集合
     * @return
     */
    ResApi<String> deletePhoto(String id);
}
