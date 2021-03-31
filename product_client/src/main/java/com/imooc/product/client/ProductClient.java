package com.imooc.product.client;

import com.imooc.product.common.CartDto;
import com.imooc.product.common.ProductInfoDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "product")
public interface ProductClient {
    @PostMapping("product/listForOrder")
    List<ProductInfoDTO> listForOrder(@RequestBody List<String> productIds);

    @PostMapping("product/deleteProductForOrder")
    void deleteProductForOrder(@RequestBody List<CartDto> cartDtoList);
}
