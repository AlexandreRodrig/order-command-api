package com.ordercommandapi.ordercommandapi.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.command.AsyncResult;
import com.ordercommandapi.ordercommandapi.controller.dto.ProductDto;
import com.ordercommandapi.ordercommandapi.controller.feign.ProductProxy;
import com.ordercommandapi.ordercommandapi.service.model.Order;
import lombok.extern.slf4j.Slf4j;
import net.logstash.logback.argument.StructuredArguments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Service
@Slf4j
public class OrderService {

    private ProductProxy productProxy;

    @Autowired
    public OrderService(ProductProxy productProxy) {
        this.productProxy = productProxy;
    }

    @HystrixCommand(groupKey = "order", commandKey = "createOrder", fallbackMethod = "createOrderFallback")
    public Future<Order> createOrder(Order order) {
        return new AsyncResult<Order>() {
            @Override
            public Order invoke() {
                log.info("Sending order {} to command bus",
                        StructuredArguments.value("description", order.getDescription()));
                return new Order();
            }
        };
    }

    public Order createOrderFallback(Order order, Throwable ex) {
        log.error("Fail to create new order. {}", StructuredArguments.value("description", order.getDescription()), ex);
        return null;
    }

    public ProductDto getProduct(int id) {
        return productProxy.getProduct(id);
    }
}
