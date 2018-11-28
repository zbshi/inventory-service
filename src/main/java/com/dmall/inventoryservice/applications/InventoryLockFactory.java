package com.dmall.inventoryservice.applications;

import com.dmall.inventoryservice.domain.InventoryLock;

public class InventoryLockFactory {

    public static InventoryLock ToDomain(long productId, int quantity) {
        InventoryLock inventoryLock = new InventoryLock();
        inventoryLock.setProductId(productId);
        inventoryLock.setQuantity(quantity);
        return inventoryLock;
    }
}
