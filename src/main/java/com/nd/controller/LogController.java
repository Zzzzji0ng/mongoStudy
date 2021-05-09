package com.nd.controller;

import com.nd.entity.LogEntity;
import com.nd.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/log")
public class LogController {

    @Autowired
    private ILogService logServiceImpl;

    @GetMapping
    public List<LogEntity> findAllByNameAndAge(String name, Integer age) {
        return logServiceImpl.findAllByNameAndAge(name, age);
    }

    @PostMapping
    public LogEntity saveLog(@RequestBody LogEntity logEntity) {
        return logServiceImpl.save(logEntity);
    }

    @PutMapping(value = "/{id}")
    public LogEntity updateLog(@PathVariable String id, @RequestBody LogEntity logEntity){
        logEntity.set_id(id);
        return logServiceImpl.updateById(logEntity);
    }

    @DeleteMapping(value = "/{id}")
    public void deleteLog(@PathVariable String id) {
        logServiceImpl.deleteById(id);
    }
}
