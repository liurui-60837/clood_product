package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductInfoResitory extends JpaRepository<ProductInfo,String> {

    List<ProductInfo> findProductInfoByProductStatus(Integer productStatus);

    List<ProductInfo> findProductInfosByProductId(List<String> productIdList);
}
