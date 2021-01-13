package com.william.controller.RestController.RestAdminController;


import com.william.entity.AccountEntity;
import com.william.entity.LoginEntity;
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

    @GetMapping
    public Response showList(){
        Iterable<AccountEntity> list = accountService.findAll();
        res.setData( list);
        res.setStatus(ResponseStatus.SUCCESS) ;
        res.setMessage("Success");
        return res;
    }


    @PostMapping
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
    public Response update(@RequestBody AccountEntity a ){
        res.setData(accountService.save(a));
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

    @PostMapping("/check")
    public Response checkLogin(@RequestBody LoginEntity l){
        if (accountService.existsAccountEntitiesByUsernameAndPassword(l.getUsername(), l.getPassword())) {
            res.setData(accountService.findByUsername(l.getUsername()));
            res.setStatus(ResponseStatus.SUCCESS);
            res.setMessage("Success");

        }else {
            res.setStatus(ResponseStatus.ERROR);
        }
        return res;
    }

    @GetMapping("/find")
    public Response find(@RequestParam int id){
        res.setData(accountService.findById(id));
        res.setStatus(ResponseStatus.SUCCESS);
        res.setMessage("Success");
        return res;
    }
}
