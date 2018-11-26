package cn.itcast.service;

import cn.itcast.domain.Role;

import java.util.List;

public interface IRoleService {
    public List<Role> findAll(Integer page, Integer size);

    public abstract void save(Role role);

    List<Role> findByUid(String uid);

    void addPermissionToRole(String rid, String[] ids);

    Role findByRId(String id);
}
