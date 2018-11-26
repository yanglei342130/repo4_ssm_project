package cn.itcast.service.impl;

import cn.itcast.dao.ISysLogDao;
import cn.itcast.domain.SysLog;
import cn.itcast.service.ISysLogService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISysLogDao sysLogDao;
    @Override
    public void save(SysLog log) {
        sysLogDao.save(log);
    }

    @Override
    public List<SysLog> findAll(Integer page,Integer size) {
        PageHelper.startPage(page,size);
        return sysLogDao.findAll();
    }
}
