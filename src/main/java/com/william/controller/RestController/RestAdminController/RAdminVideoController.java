package com.william.controller.RestController.RestAdminController;

import com.william.entity.Response;
import com.william.entity.ResponseStatus;
import com.william.entity.VideosEntity;
import com.william.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/videos")
public class RAdminVideoController {
    @Autowired
    private VideoService videoService;

    Response response = new Response();

    @PostMapping
    public Response addNewVideo(@RequestBody VideosEntity videosEntity) {
        videoService.save(videosEntity);
        response.setData(videosEntity);
        response.setStatus(ResponseStatus.SUCCESS);
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
    @DeleteMapping
    public Response deleteVideo(@RequestParam(name = "idVideo") int id) {
        videoService.deleteById(id);
        response.setData("ok");
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }
    @GetMapping("/find")
    public Response findVideo(@RequestParam(name = "idVideo") int id) {
        Optional<VideosEntity> videosEntity = videoService.findById(id);
        if (videosEntity == null){
            response.setData(null);
            response.setStatus(ResponseStatus.ERROR);
            response.setMessage("ERROR");
            return response;
        }
        response.setData(videosEntity);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }

}
