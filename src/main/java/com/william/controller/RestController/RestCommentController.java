package com.william.controller.RestController;

import com.william.entity.CommentEntity;
import com.william.entity.Response;
import com.william.entity.ResponseStatus;
import com.william.entity.RolesEntity;
import com.william.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/comment")
public class RestCommentController {
    @Autowired
    private ICommentService commentService;

    Response response = new Response();
    @GetMapping
    public Response comment(){
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(commentService.findAll());
        response.setMessage("SUCCESS");
        return response;
    }
    @PostMapping
    public Response addComment(@RequestBody CommentEntity commentEntity){
        commentService.save(commentEntity);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(commentEntity);
        response.setMessage("SUCCESS");
        return response;
    }
    @DeleteMapping
    public Response deleteComment(@RequestParam("idComment") int id){
        commentService.deleteById(id);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(null);
        response.setMessage("SUCCESS");
        return response;
    }

    @PatchMapping
    public Response findCommentByPost(@RequestParam("idVideo") int id){
        List<CommentEntity> commentEntities = new ArrayList<>();
        for (CommentEntity comment : commentService.findAll()) {
            if(comment.getVideoid() == id){
                commentEntities.add(comment);
            }
        }
        response.setStatus(ResponseStatus.SUCCESS);
        response.setData(commentEntities);
        response.setMessage("SUCCESS");
        return response;
    }
}
