package com.gp.cms.controller;

import com.gp.cms.model.entity.ResApi;
import com.gp.cms.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@RestController
@RequestMapping("api")
public class PhotoController {
    @Autowired
    private PhotoService photoService;

    /**
     * 查询照片
     *
     * @param albumId  相册id
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "photo", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryPhoto(@RequestParam Long albumId,
                                                  @RequestParam Integer pageNo,
                                                  @RequestParam Integer pageSize) {
        return photoService.queryPhoto(albumId, pageNo, pageSize);
    }

    /**
     * 上传照片
     *
     * @param file    文件
     * @param albumId 相册id
     * @return
     */
    @RequestMapping(value = "photo", method = RequestMethod.POST)
    public ResApi<String> uploadPhoto(MultipartFile file, @RequestParam Long albumId) {
        return photoService.uploadPhoto(file, albumId);
    }

    /**
     * 删除照片
     *
     * @param id 照片id集合
     * @return
     */
    @RequestMapping(value = "photo", method = RequestMethod.DELETE)
    public ResApi<String> deletePhoto(@RequestParam String id) {
        return photoService.deletePhoto(id);
    }
}
