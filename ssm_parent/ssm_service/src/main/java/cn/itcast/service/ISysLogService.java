package cn.itcast.service;

import cn.itcast.domain.SysLog;

import java.util.List;

public interface ISysLogService {
    public void save(SysLog log);
    List<SysLog> findAll(Integer page, Integer size);
}
