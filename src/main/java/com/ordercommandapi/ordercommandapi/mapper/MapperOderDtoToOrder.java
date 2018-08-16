package com.ordercommandapi.ordercommandapi.mapper;

import com.ordercommandapi.ordercommandapi.controller.dto.OrderDto;
import com.ordercommandapi.ordercommandapi.service.model.Order;

public class MapperOderDtoToOrder {

    public static Order map(OrderDto orderDto){

        Order order = new Order();
        order.setDaypart(orderDto.getDaypart());
        order.setDescription(orderDto.getDescription());
        order.setEndDateTime(orderDto.getEndDateTime());
        order.setStartDateTime(orderDto.getStartDateTime());
        order.setPrice(orderDto.getPrice());
        return order;
    }

}
