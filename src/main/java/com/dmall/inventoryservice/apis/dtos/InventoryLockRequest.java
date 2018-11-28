package com.dmall.inventoryservice.apis.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class InventoryLockRequest {

    private Long productId;

    private Integer quantity;

}
