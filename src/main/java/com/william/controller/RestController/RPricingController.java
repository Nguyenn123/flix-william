package com.william.controller.RestController;

import com.william.entity.Response;
import com.william.entity.ResponseStatus;
import com.william.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/pricing")
public class RPricingController {
    @Autowired
    private IProductService productService;
    Response response = new Response();

    @GetMapping
    public Response pricing() {
        response.setData(productService.findAll());
        response.setMessage("SUCCESS");
        response.setStatus(ResponseStatus.SUCCESS);
        return response;
    }
}
