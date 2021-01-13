package com.william.controller.RestController.RestAdminController;

import com.william.entity.Response;
import com.william.entity.ResponseStatus;
import com.william.entity.RolesEntity;
import com.william.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/roles")
public class RAdminRolesController {
    @Autowired
    private IRolesService rolesService;
    Response response = new Response();
    @GetMapping
    public Response roles(){
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(rolesService.findAll());
        response.setMessage("SUCCESS");
        return response;
    }
    @PostMapping
    public Response roles(@RequestBody RolesEntity rolesEntity){
        rolesService.save(rolesEntity);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(rolesEntity);
        response.setMessage("SUCCESS");
        return response;
    }
    @DeleteMapping
    public Response roles(@RequestParam("idRole") int id){
        rolesService.deleteById(id);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(null);
        response.setMessage("SUCCESS");
        return response;
    }
    @PutMapping
    public Response rolesFind(@RequestParam("idRole") int id){
        Optional<RolesEntity> rolesEntity = rolesService.findById(id);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(rolesEntity.get());
        response.setMessage("SUCCESS");
        return response;
    }
}
