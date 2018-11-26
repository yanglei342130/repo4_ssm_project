package cn.itcast.dao;

import cn.itcast.domain.SysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISysLogDao {
    /*    @Select("select * from syslog")
        @Results({
                @Result(id=true,column="id",property="id"),
                @Result(column="visitTime",property="visitTime"),
                @Result(column="ip",property="ip"),
                @Result(column="url",property="url"),
                @Result(column="executionTime",property="executionTime"),
                @Result(column="method",property="method"),
                @Result(column="username",property="username")
        })
        public List<SysLog> findAll();
        @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
        public void save(SysLog log);*/
    @Select("select * from syslog")
    public List<SysLog> findAll();
    @Insert("insert into syslog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    public abstract void save(SysLog sysLog);
}

