package com.dmall.inventoryservice.applications;

import com.dmall.inventoryservice.domain.Inventory;

public class InventoryFactory {

    public static Inventory ToDomain(long productId, int quantity) {
        Inventory inventory = new Inventory();
        inventory.setProductId(productId);
        inventory.setQuantity(quantity);
        return inventory;
    }

}
