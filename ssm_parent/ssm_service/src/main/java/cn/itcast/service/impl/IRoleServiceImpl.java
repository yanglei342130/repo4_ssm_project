package cn.itcast.service.impl;

import cn.itcast.dao.IRoleDao;
import cn.itcast.domain.Role;
import cn.itcast.service.IRoleService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IRoleServiceImpl implements IRoleService {

    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) {
        roleDao.save(role);
    }

    @Override
    public List<Role> findByUid(String uid) {
        return roleDao.findByUid(uid);
    }

    @Override
    public void addPermissionToRole(String rid, String[] ids) {
        for (String id : ids) {
            roleDao.addPermissionToRole(rid,id);
        }

    }

    @Override
    public Role findByRId(String id) {
        return roleDao.findByRid(id);
    }


}
