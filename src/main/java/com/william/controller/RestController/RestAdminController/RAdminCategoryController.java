package com.william.controller.RestController.RestAdminController;

import com.william.entity.CategoryEntity;
import com.william.entity.Response;
import com.william.entity.ResponseStatus;
import com.william.entity.VideosEntity;
import com.william.service.CategoryService;
import com.william.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/category")
public class RAdminCategoryController {
    @Autowired
    private CategoryService categoryService;

    Response response = new Response();

    @PostMapping
    public Response addNewCategory(@RequestBody CategoryEntity categoryEntity) {
        categoryService.save(categoryEntity);
        response.setData(categoryEntity);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }
    @GetMapping
    public Response allCategory() {
        Iterable<CategoryEntity> categoryEntities = categoryService.findAll();
        response.setData(categoryEntities);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }
    @DeleteMapping
    public Response deleteCategory(@RequestParam(name = "idCategory") int id) {
        categoryService.deleteById(id);
        response.setData("ok");
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }
    @GetMapping("/find")
    public Response findCategory(@RequestParam(name = "idCategory") int id) {
        Optional<CategoryEntity> categoryEntity = categoryService.findById(id);
        if (categoryEntity == null){
            response.setData(null);
            response.setStatus(ResponseStatus.ERROR);
            response.setMessage("ERROR");
            return response;
        }
        response.setData(categoryEntity);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }

}
