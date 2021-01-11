package com.william.controller.RestController.RestAdminController;

import com.william.entity.Response;
import com.william.entity.ResponseStatus;
import com.william.entity.VideosEntity;
import com.william.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RAdminVideoController {
    @Autowired
    private VideoService videoService;

    Response response = new Response();

    @RequestMapping(value = "/addVideoApi",method = RequestMethod.POST)
    public Response addNewVideo(@RequestBody VideosEntity videosEntity) {
        videoService.save(videosEntity);
        response.setData(videosEntity);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }
    @RequestMapping(value = "/addVideoApi",method = RequestMethod.GET)
    public Response allVideos() {
        Iterable<VideosEntity> videosEntities = videoService.findAll();
        response.setData(videosEntities);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }
}
