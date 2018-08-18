package com.ordercommandapi.ordercommandapi.controller.feign;

import com.ordercommandapi.ordercommandapi.controller.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "ihm-product-api", decode404 = true)
public interface ProductProxy {

    @RequestMapping(method = RequestMethod.GET, value = "/v1/products/{productId}")
    ProductDto getProduct(@PathVariable(name = "productId") Integer productId);

}
