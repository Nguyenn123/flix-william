package com.william.service;

import com.william.entity.StatusEntity;
import com.william.repository.IStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class StatusService implements IStatusService{
    @Autowired
    IStatusRepository iStatusRepository;
    @Override
    public StatusEntity save(StatusEntity statusEntity) {
        iStatusRepository.save(statusEntity);
        return statusEntity;
    }

    @Override
    public Optional<StatusEntity> findById(int id) {
        Optional<StatusEntity> statusEntity = iStatusRepository.findById(id);
        return statusEntity;
    }


    @Override
    public Iterable<StatusEntity> findAll() {
        return iStatusRepository.findAll();
    }

    @Override
    public boolean remove(int id) {
        boolean isDelete = false;
        try{
           iStatusRepository.deleteById(id);
            isDelete = true;
        }catch (Exception ex){
            System.out.println(ex);
        }
        return isDelete;
    }
}
