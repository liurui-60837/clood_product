package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductCategory;
import com.imooc.product.dataobject.ProductInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface ProductCategoryResitory extends JpaRepository<ProductCategory ,String> {

    List<ProductCategory> findProductCategoryByCategoryTypeIn(List<Integer> categoryTypeList);

}
