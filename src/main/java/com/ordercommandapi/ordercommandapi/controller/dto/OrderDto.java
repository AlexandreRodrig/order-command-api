package com.ordercommandapi.ordercommandapi.controller.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class OrderDto {
    private String description;
    private String daypart;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Float price;

}
