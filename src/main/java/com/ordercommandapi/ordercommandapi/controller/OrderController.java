package com.ordercommandapi.ordercommandapi.controller;

import com.ordercommandapi.ordercommandapi.controller.dto.OrderDto;
import com.ordercommandapi.ordercommandapi.mapper.MapperOderDtoToOrder;
import com.ordercommandapi.ordercommandapi.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@Api("/order")
@RestController
@RequestMapping(value = "/order", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.ACCEPTED)
    @ApiOperation(value = "Create an Order")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Order created."),
            @ApiResponse(code = 500, message = "Something went wrong!") }
    )
    public void createOrder(@RequestBody OrderDto orderDto) {
        orderService.createOrder(MapperOderDtoToOrder.map(orderDto));
        log.info("Order {} will be created!", orderDto.getDescription());
    }



}
