package com.william.controller.RestController;

import com.william.entity.Response;
import com.william.entity.ResponseStatus;
import com.william.entity.VideosEntity;
import com.william.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@CrossOrigin("*")
@RequestMapping("api/videosHome")
public class RHomeVideosController {
    @Autowired
    private VideoService videoService;

    Response response = new Response();

    @PostMapping
    public Response addNewVideo(@RequestBody VideosEntity videosEntity) {
        videoService.save(videosEntity);
        response.setData(videosEntity);
        response.setStatus(com.william.entity.ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }
    @GetMapping("/videosnew")
    public Response videosNew() {
        ArrayList<VideosEntity> videosEntities2 = (ArrayList<VideosEntity>) videoService.findAll();
        ArrayList<VideosEntity> videosEntities = new ArrayList<>();
        videosEntities.add(videosEntities2.get(0));
        videosEntities.add(videosEntities2.get(1));
        videosEntities.add(videosEntities2.get(1));
        response.setData(videosEntities);
        response.setStatus(com.william.entity.ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }

    @GetMapping
    public Response allVideos() {
        Iterable<VideosEntity> videosEntities = videoService.findAll();
        response.setData(videosEntities);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }

}
