package com.nd.service;

import com.nd.entity.LogEntity;

import java.util.List;

public interface ILogService {

    List<LogEntity> findAllByNameAndAge(String name, Integer age);

}
