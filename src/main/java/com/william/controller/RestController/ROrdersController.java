package com.william.controller.RestController;

import com.william.entity.OrdersEntity;
import com.william.entity.Response;
import com.william.entity.ResponseStatus;
import com.william.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/orders")
public class ROrdersController {
    @Autowired
    private IOrdersService ordersService;
    Response response = new Response();
    @GetMapping
    public Response orders(){
        response.setData(ordersService.findAll());
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }
    @PostMapping
    public Response orders(@RequestBody OrdersEntity oders){
        ordersService.save(oders);
        response.setData(oders);
        response.setStatus(ResponseStatus.SUCCESS);
        response.setMessage("SUCCESS");
        return response;
    }

}
