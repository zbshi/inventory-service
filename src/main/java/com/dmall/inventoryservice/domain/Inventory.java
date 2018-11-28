package com.dmall.inventoryservice.domain;

import com.dmall.inventoryservice.infrastructure.exception.CustomizeException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {
    private long id;

    private Long productId;

    private Integer quantity;

    public void deduct(int quantity) {
        if (this.quantity < quantity) {
            throw new CustomizeException(" not enough inventory");
        }
        this.quantity = this.quantity - quantity;
    }
}
