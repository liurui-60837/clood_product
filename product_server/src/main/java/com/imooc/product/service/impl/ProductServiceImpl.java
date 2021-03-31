package com.imooc.product.service.impl;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.dto.CartDto;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.SellException;
import com.imooc.product.repository.ProductInfoResitory;
import com.imooc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoResitory productInfoResitory;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoResitory.findProductInfoByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfo> findAllById(List<String> productIdList) {
        return productInfoResitory.findProductInfosByProductId(productIdList);
    }

    /**
     *
     * @Description: 减库存
     * @Author: liurui
     * @Date: 2021/3/30 17:20
     * @param [cartDtoList]
     * @return void
     **/
    @Override
    @Transactional
    public void decreaseStock(List<CartDto> cartDtoList) {
        for (CartDto cartDto:cartDtoList) {
            ProductInfo productInfo = productInfoResitory.findById(cartDto.getProductId()).get();
            if(productInfo == null){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            Integer result =  productInfo.getProductStock() - cartDto.getProductQuantity();
            if(result<0){
                throw new SellException(ResultEnum.PRODUCT_NOT_EXIST);
            }
            productInfo.setProductStock(result);
            productInfoResitory.save(productInfo);

        }
    }
}
