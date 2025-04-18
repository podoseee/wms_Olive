package com.minisec.user.model.dto.order;

import com.minisec.user.model.dto.OrderProductDto;
import com.minisec.user.model.dto.store.StoreDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class OrderDto {

    private int orderId;
    private int userId;
    private String orderStatus;
    private String orderDate;

    private int totalQuantity;
    private int totalPrice;

    private String orderMemo;

    private StoreDto store;
    private List<OrderProductDto> orderProducts;


    public OrderDto(StoreDto store, int userId, String orderStatus, List<OrderProductDto> orderProducts) {
        this.store = store;
        this.userId = userId;
        this.orderStatus = orderStatus;
        this.orderProducts = orderProducts;
        calculateTotalPriceAndQuantity();
    }

    public void calculateTotalPriceAndQuantity() {
        totalPrice = 0;
        totalQuantity = 0;
        for (OrderProductDto orderProductDto : orderProducts) {
            totalPrice += orderProductDto.getTotalPrice();
            totalQuantity += orderProductDto.getQuantity();
        }
    }

}
