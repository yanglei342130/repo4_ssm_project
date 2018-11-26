package cn.itcast.service;

import cn.itcast.domain.Permission;

import java.util.List;

public interface IPermissionService {

    public abstract List<Permission> findAll(Integer page, Integer size);

    public abstract void save(Permission permission);

    public abstract List<Permission> findPermissionByRid(String rid);
}
