package cn.itcast.dao;

import cn.itcast.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface IRoleDao {

    @Select("select * from role where id in (select roleid from users_role where userid = #{id})")
    @Results({@Result(id = true,column = "id",property = "id"),
    @Result(column = "roleName",property = "roleName"),
    @Result(column = "roleDesc",property = "roleDesc"),
    @Result(column = "id",property = "permissions",many = @Many(select = "cn.itcast.dao.IPermissionDao.findById"))})
    public List<Role> findById(String id);

    @Select("select * from role")
    public List<Role> findAll();

    @Insert("insert into role (roleName,roleDesc) values(#{roleName},#{roleDesc})")
    public void save(Role role);

    @Select("select * from role where id not in (select roleId from users_role where userId = #{uid})")
    public List<Role> findByUid(String uid);

    @Insert("insert into role_permission (permissionId,roleId) values(#{permissionId},#{roleId})")
    void addPermissionToRole(@Param("roleId") String rid,@Param("permissionId") String id);

    @Select("select * from role where id = #{rid}")
    @Results({@Result(id = true,column = "id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",many = @Many(select = "cn.itcast.dao.IPermissionDao.findById"))})
    Role findByRid(String rid);
   /* @Select("select * from role where id in (select roleid from users_role where userid = #{id})")
    public List<Role> findById(String id);*/

}
