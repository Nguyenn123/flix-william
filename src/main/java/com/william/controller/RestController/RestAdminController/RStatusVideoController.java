package com.william.controller.RestController.RestAdminController;

import com.william.entity.Response;
import com.william.entity.ResponseStatus;
import com.william.entity.RolesEntity;
import com.william.entity.StatusVideoEntity;
import com.william.service.IStatusVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("api/statusvideo")
public class RStatusVideoController {
    @Autowired
    private IStatusVideoService statusVideoService;
    Response response = new Response();

    @GetMapping
    public Response statusVideo() {
        Iterable<StatusVideoEntity> statusVideoEntities = statusVideoService.findAll();
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(statusVideoEntities);
        response.setMessage("SUCCESS");
        return response;
    }

    @PostMapping
    public Response statusVideo(@RequestBody StatusVideoEntity statusVideoEntity) {
        statusVideoService.save(statusVideoEntity);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(statusVideoEntity);
        response.setMessage("SUCCESS");
        return response;
    }

    @DeleteMapping
    public Response statusVideo(@RequestParam("idRole") int id) {
        statusVideoService.deleteById(id);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(null);
        response.setMessage("SUCCESS");
        return response;
    }

    @PutMapping
    public Response statusVideoFind(@RequestParam("idRole") int id) {
        Optional<StatusVideoEntity> statusVideoEntity = statusVideoService.findById(id);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(statusVideoEntity);
        response.setMessage("SUCCESS");
        return response;
    }
}
