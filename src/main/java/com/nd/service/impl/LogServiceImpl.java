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

    @Override
    public LogEntity updateById(LogEntity logEntity) {
        // 这里最好使用的是 update 方法，避免使用 save 覆盖造成数据错误
        return logDao.save(logEntity);
    }

    @Override
    public LogEntity save(LogEntity logEntity) {
        return logDao.save(logEntity);
    }

    @Override
    public void deleteById(String id) {
        logDao.deleteById(id);
    }
}
