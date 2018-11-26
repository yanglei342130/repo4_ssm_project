package cn.itcast.dao;

import cn.itcast.domain.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IOrdersDao {
    @Select("select * from orders")
    @Results({@Result(id = true,property = "id",column = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product", one = @One(select = "cn.itcast.dao.IProductDao.findById"))})
    public abstract List<Orders> findAll();

    @Select("select * from orders where id = #{id}")
    @Results({@Result(id = true,property = "id",column = "id"),
            @Result(column = "orderNum",property = "orderNum"),
            @Result(column = "orderTime",property = "orderTime"),
            @Result(column = "orderStatus",property = "orderStatus"),
            @Result(column = "peopleCount",property = "peopleCount"),
            @Result(column = "payType",property = "payType"),
            @Result(column = "orderDesc",property = "orderDesc"),
            @Result(column = "productId",property = "product", one = @One(select = "cn.itcast.dao.IProductDao.findById")),
            @Result(column = "memberId",property = "member",one = @One(select = "cn.itcast.dao.IMemberDao.findById")),
            @Result(column = "id" , property = "travellers",many = @Many(select = "cn.itcast.dao.ITravellerDao.findById"))})
    public abstract Orders findById(String id);

}
