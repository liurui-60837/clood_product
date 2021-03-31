package com.imooc.product.service.impl;

import com.imooc.product.common.CartDto;
import com.imooc.product.common.ProductInfoDTO;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exception.SellException;
import com.imooc.product.repository.ProductInfoResitory;
import com.imooc.product.service.ProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductInfoResitory productInfoResitory;

    @Override
    public List<ProductInfo> findUpAll() {
        return productInfoResitory.findProductInfoByProductStatus(ProductStatusEnum.UP.getCode());
    }

    @Override
    public List<ProductInfoDTO> findAllById(List<String> productIdList) {
        return productInfoResitory.findProductInfosByProductId(productIdList).stream().map(
                e->{
                    ProductInfoDTO productInfoDTO = new ProductInfoDTO();
                    BeanUtils.copyProperties(e,productInfoDTO);
                    return productInfoDTO;
                }).collect(Collectors.toList());
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
