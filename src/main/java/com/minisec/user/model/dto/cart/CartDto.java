package com.minisec.user.model.dto.cart;

import com.minisec.user.model.dto.order.OrderProductDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter
@Setter
@ToString
public class CartDto {

    private Integer cartId; ///존재하는지 확인하는 용도
    private int storeId;
    private String storeName;
    private int userId;

    private OrderProductDto orderProduct;

    public CartDto(int storeId, int userId, OrderProductDto orderProduct) {
        this.storeId = storeId;
        this.userId = userId;
        this.orderProduct = orderProduct;
    }

}
