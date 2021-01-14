package com.william.controller.RestController.RestAdminController;

import com.william.entity.*;
import com.william.entity.ResponseStatus;
import com.william.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class RCategoryControllerAmin {

    @Autowired
    private ICategoryService categoryService;
    @Autowired
    private IStatusService statusService;
    Response response = new Response();


    @GetMapping()
    public Response findAllCategory() {
        Iterable<CategoryEntity> videosEntities = categoryService.findAll();
        response.setData(videosEntities);
        response.setMessage("ok");
        response.setStatus(ResponseStatus.SUCCESS);
        return response;

    }

    @GetMapping("/detail")
    public Response findByID(@RequestParam int id) {
        Optional<CategoryEntity> categoryEntityOptional = categoryService.findById(id);

        response.setData(categoryEntityOptional);
        response.setMessage("ok");
        response.setStatus(ResponseStatus.SUCCESS);
        return response;

    }

    @PutMapping("/update")
    public Response update(@RequestBody CategoryEntity c) {
        categoryService.save(c);
        response.setData(c);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("ok");
        return response;
    }

    @PostMapping("/create")
    public Response create(@RequestBody CategoryEntity c) {
        categoryService.save(c);
        response.setData(c);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("ok");
        return response;
    }


    @DeleteMapping("/delete")
    public Response delete(@RequestParam int id) {
        categoryService.deleteById(id);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("ok");
        return response;
    }


}
