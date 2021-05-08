package com.nd.dao;

import com.nd.entity.LogEntity;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface LogDao extends MongoRepository<LogEntity, String> {

    List<LogEntity> findAllByNameAndAge(String name, Integer age);


}
