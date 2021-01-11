package com.william.controller.RestController.RestAdminController;


import com.william.entity.AccountEntity;
import com.william.entity.Response;
import com.william.entity.ResponseStatus;
import com.william.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@RestController
@CrossOrigin("*")
@RequestMapping("/home/login")
public class RestAccountController {

    @Autowired
    private IAccountService accountService;
    Response res = new Response();

    @GetMapping("/")
    public Response showList(){
        Iterable<AccountEntity> list = accountService.findAll();
        res.setData( list);
        res.setStatus(ResponseStatus.SUCCESS) ;
        res.setMessage("Success");
        return res;
    }


    @PostMapping("/")
    public Response create(@RequestBody AccountEntity a){
        a.setRole(10002);
        a.setStatusAccount(10002);
        a.setStatusMember(10001);
        a.setCreateTime(Timestamp.valueOf(LocalDateTime.now()));
        res.setData( accountService.save(a));
        res.setStatus(ResponseStatus.SUCCESS) ;
        res.setMessage("Success");
        return res;
    }

    @PutMapping("/{id}")
    public Response update(@PathVariable int id){
        res.setData(accountService.findById(id));
        res.setStatus(ResponseStatus.SUCCESS) ;
        res.setMessage("Success");
        return res;
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable int id) {
        res.setData(accountService.findById(id));
        res.setStatus(ResponseStatus.SUCCESS) ;
        res.setMessage("Success");
        accountService.remove(id);
        return res;
    }

}
