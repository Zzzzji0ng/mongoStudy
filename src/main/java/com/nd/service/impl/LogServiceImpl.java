package com.nd.service.impl;

import com.nd.dao.LogDao;
import com.nd.entity.LogEntity;
import com.nd.service.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class LogServiceImpl implements ILogService {

    @Autowired
    private LogDao logDao;

    @Override
    public List<LogEntity> findAllByNameAndAge(String name, Integer age) {
        return logDao.findAllByNameAndAge(name, age);
    }
}
