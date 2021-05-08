package com.nd.controller;

import com.nd.entity.LogEntity;
import com.nd.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
