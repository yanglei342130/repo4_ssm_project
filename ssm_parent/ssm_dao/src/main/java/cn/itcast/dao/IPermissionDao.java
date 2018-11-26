package cn.itcast.dao;

import cn.itcast.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissionDao {

    @Select("select * from permission where id in(select permissionId from role_permission where roleId = #{id})")
    public abstract List<Permission> findById(String id);

    @Select("select * from permission")
    public abstract List<Permission> findAll();

    @Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    public void save(Permission permission);

    @Select("select * from permission where id not in (select permissionId from role_permission where roleId = #{rid})")
    public List<Permission> findPermissionByRid(String rid);
}
