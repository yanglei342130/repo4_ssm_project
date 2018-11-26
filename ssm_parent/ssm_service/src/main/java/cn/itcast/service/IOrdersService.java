package cn.itcast.service;

import cn.itcast.domain.Orders;

import java.util.List;

public interface IOrdersService {
    public List<Orders> findAll(int page,int size);
    public abstract Orders findById(String id);
}
