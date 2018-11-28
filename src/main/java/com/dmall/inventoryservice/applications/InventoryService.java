package com.dmall.inventoryservice.applications;

import com.dmall.inventoryservice.domain.Inventory;
import com.dmall.inventoryservice.domain.InventoryLock;
import com.dmall.inventoryservice.infrastructure.repositories.InventoryLockRepository;
import com.dmall.inventoryservice.infrastructure.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryLockRepository inventoryLockRepository;

    public void createInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    public void lockInventory(InventoryLock inventoryLock) {
        inventoryLockRepository.save(inventoryLock);
    }

    public void deductInventory(long productId, int quantity) {

        synchronized (this) {
            Inventory inventory = inventoryRepository.getByProductId(productId);
            inventory.deduct(quantity);
            inventoryRepository.update(inventory);
        }

    }
}
