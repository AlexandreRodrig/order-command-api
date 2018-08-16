package com.ordercommandapi.ordercommandapi.service.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class Order {
    private String description;
    private String daypart;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Float price;
}
