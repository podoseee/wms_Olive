package com.minisec.user.view.printer.cart;

import com.minisec.user.model.dto.store.StoreProductDto;
import com.minisec.user.model.dto.OrderProductDto;
import com.minisec.user.model.dto.store.StoreDto;

import java.util.List;
import java.util.Map;

public class CartDetailsPrinter {

    private final static String CART_DETAILS = "%d. [ %s - %,d개 | %,d원 ] - 브랜드 : %s | 카테고리 : %s\n";

    public static void print(Map<StoreDto, List<OrderProductDto>> cartByStoreList,
                             Map<StoreDto, List<OrderProductDto>> orderList) {

        System.out.println(" --------------------------- 장바구니----------------------------");
        if (cartByStoreList == null || cartByStoreList.isEmpty()) {
            System.out.println("장바구니가 비어있습니다.");
        } else {
            printDetails(cartByStoreList);
        }

        System.out.println(" \n\n--------------------------- 구매 목록 ----------------------------");
        if (orderList == null || orderList.isEmpty()) {
            System.out.println("구매 목록이 비어있습니다.");
        } else {
            printDetails(orderList);
        }
        System.out.println();
        System.out.println();
        System.out.println();
    }


    private static void printDetails(Map<StoreDto, List<OrderProductDto>> details) {
        int totalPrice = 0;
        int totalQuantity = 0;

        for (Map.Entry<StoreDto, List<OrderProductDto>> entry : details.entrySet()) {
            StoreDto store = entry.getKey();
            List<OrderProductDto> products = entry.getValue();

            System.out.printf("< %s >\n", store.getStoreName());
            for (int i = 0; i < products.size(); i++) {
                OrderProductDto orderProductDetail = products.get(i);
                StoreProductDto product = orderProductDetail.getProduct();

                System.out.printf(CART_DETAILS,
                        i + 1,
                        product.getProductName(),
                        orderProductDetail.getQuantity(),
                        orderProductDetail.getTotalPrice(),
                        product.getBrandName(),
                        product.getCategory()
                );

                totalPrice += orderProductDetail.getTotalPrice();
                totalQuantity += orderProductDetail.getQuantity();
            }
            System.out.println();
        }
        System.out.println("........................");
        System.out.printf("총 가격 : %,d원\n", totalPrice);
        System.out.printf("총 수량 : %,d개\n", totalQuantity);
    }


    public static void printUniqueNumber(Map<StoreDto, List<OrderProductDto>> cartByStoreList) {
        if (cartByStoreList == null || cartByStoreList.isEmpty()) {
            System.out.println("\n\n장바구니가 비어있습니다.");
            return;
        }
        int uniqueNumber = 1;

        for (Map.Entry<StoreDto, List<OrderProductDto>> entry : cartByStoreList.entrySet()) {
            StoreDto storeDto = entry.getKey();
            List<OrderProductDto> productList = entry.getValue();

            System.out.printf("\n\n< %s >\n", storeDto.getStoreName());
            for (OrderProductDto orderProductDetail : productList) {
                StoreProductDto product = orderProductDetail.getProduct();

                System.out.printf(CART_DETAILS,
                        uniqueNumber,
                        product.getProductName(),
                        orderProductDetail.getQuantity(),
                        orderProductDetail.getTotalPrice(),
                        product.getBrandName(),
                        product.getCategory()
                );
                uniqueNumber++;
            }
        }
        System.out.println();
    }

}