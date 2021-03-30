package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductCategory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductCategoryResitoryTest {

    @Autowired
    private ProductCategoryResitory productCategoryResitory;

    @Test
    public void findProductCategoryByCategoryType(){
        List<Integer> ali = new ArrayList<>();
        ali.add(11);
        ali.add(22);
        List<ProductCategory> list = productCategoryResitory.findProductCategoryByCategoryTypeIn(ali);
        list.stream().forEach(e->{
            System.out.println(e.getCategoryName());
        });
    }
}