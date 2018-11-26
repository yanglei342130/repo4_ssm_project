package cn.itcast.service;

import cn.itcast.domain.Product;

import java.util.List;


public interface IProductService {
    public abstract List<Product> findAll(int page,int size);
    public abstract void insertOne(Product product);
}
