package com.nd.service;

import com.nd.entity.LogEntity;

import java.util.List;

public interface ILogService {

    List<LogEntity> findAllByNameAndAge(String name, Integer age);

    LogEntity updateById(LogEntity logEntity);

    LogEntity save(LogEntity logEntity);

    void deleteById(String id);

}
