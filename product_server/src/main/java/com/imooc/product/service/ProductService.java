package com.imooc.product.service;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDto;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();


    List<ProductInfo>findAllById(List<String> productIdList);

    //扣库存
    //减库存
    void decreaseStock(List<CartDto> cartDtoList);
}
