package com.imooc.product.service;

import com.imooc.product.common.CartDto;
import com.imooc.product.common.ProductInfoDTO;
import com.imooc.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {

    /**
     * 查询所有在架商品列表
     * @return
     */
    List<ProductInfo> findUpAll();


    List<ProductInfoDTO>findAllById(List<String> productIdList);

    //扣库存
    //减库存
   void decreaseStock(List<CartDto> cartDtoList);
}
