package cn.itcast.dao;

import cn.itcast.domain.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserDao {
    @Select("select * from users where username = #{username}")
    @Results({@Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "roles",column = "id",
                    many = @Many(select = "cn.itcast.dao.IRoleDao.findById"))
    })
    public abstract UserInfo findByUsername(String username);

    @Select("select * from users")
    public abstract List<UserInfo> findAll();

    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
   public abstract void save(UserInfo userInfo);

    @Select("select * from users where id = #{id}")
    @Results({@Result(id = true,property = "id",column = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "roles",column = "id", many = @Many(select = "cn.itcast.dao.IRoleDao.findById"))
    })
    UserInfo findByID(String id);

    @Insert("insert into users_role (userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String uid,@Param("roleId") String rid);

    @Select("select * from users where username like concat(concat('%',#{username}),'%')")
    List<UserInfo> findByCondition(String username);
}
