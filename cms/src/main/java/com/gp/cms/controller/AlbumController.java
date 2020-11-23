package com.gp.cms.controller;

import com.gp.cms.model.Album;
import com.gp.cms.model.entity.ResApi;
import com.gp.cms.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("api")
public class AlbumController {
    @Autowired
    private AlbumService albumService;

    /**
     * 查询相册
     *
     * @param name     相册名
     * @param pageNo   页码
     * @param pageSize 页大小
     * @return
     */
    @RequestMapping(value = "album", method = RequestMethod.GET)
    public ResApi<Map<String, Object>> queryAlbum(@RequestParam(required = false) String name,
                                                  @RequestParam Integer pageNo,
                                                  @RequestParam Integer pageSize) {
        return albumService.queryAlbum(name, pageNo, pageSize);
    }

    /**
     * 新增相册
     *
     * @param album 相册
     * @return
     */
    @RequestMapping(value = "album", method = RequestMethod.POST)
    public ResApi<String> addAlbum(@RequestBody Album album) {
        return albumService.addAlbum(album);
    }

    /**
     * 修改相册
     *
     * @param album 相册
     * @return
     */
    @RequestMapping(value = "album", method = RequestMethod.PUT)
    public ResApi<String> updateAlbum(@RequestBody Album album) {
        return albumService.updateAlbum(album);
    }

    /**
     * 删除相册
     *
     * @param id 相册id
     * @return
     */
    @RequestMapping(value = "album", method = RequestMethod.DELETE)
    public ResApi<String> deleteAlbum(@RequestParam Long id) {
        return albumService.deleteAlbum(id);
    }
}
