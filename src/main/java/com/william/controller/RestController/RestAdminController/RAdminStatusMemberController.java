package com.william.controller.RestController.RestAdminController;

import com.william.entity.Response;
import com.william.entity.ResponseStatus;
import com.william.entity.RolesEntity;
import com.william.entity.StatusMemberEntity;
import com.william.service.IStatusMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/statusmember")
@CrossOrigin("*")
public class RAdminStatusMemberController {
    @Autowired
    private IStatusMemberService statusMemberService;
    Response response = new Response();

    @GetMapping
    public Response statusMember() {
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(statusMemberService.findAll());
        response.setMessage("SUCCESS");
        return response;
    }

    @PostMapping
    public Response statusMember(@RequestBody StatusMemberEntity statusMemberEntity) {
        statusMemberService.save(statusMemberEntity);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(statusMemberEntity);
        response.setMessage("SUCCESS");
        return response;
    }

    @DeleteMapping
    public Response statusMember(@RequestParam("idStatusMember") int id) {
        statusMemberService.deleteById(id);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(null);
        response.setMessage("SUCCESS");
        return response;
    }

    @PutMapping
    public Response statusMemberFind(@RequestParam("idStatusMember") int id) {
        Optional<StatusMemberEntity> statusMember = statusMemberService.findById(id);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(statusMember.get());
        response.setMessage("SUCCESS");
        return response;
    }
}
