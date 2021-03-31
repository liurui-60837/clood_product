package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoResitoryTest {

    @Autowired
    private ProductInfoResitory productInfoResitory;

    @Test
    public void findProductInfoByProductStatus()throws Exception {

        List<ProductInfo> list = productInfoResitory.findProductInfoByProductStatus(1);
        System.out.println(list);

    }
}