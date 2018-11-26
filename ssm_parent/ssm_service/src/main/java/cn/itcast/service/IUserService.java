package cn.itcast.service;

import cn.itcast.domain.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService {

   public abstract List<UserInfo> findAll(int page, int size);

   public abstract void save(UserInfo userInfo);

    UserInfo findById(String id);

    public abstract void addRoleToUser(String uid,String[] ids);

    List<UserInfo> findByCondition(Integer page,Integer size,String username);
}
