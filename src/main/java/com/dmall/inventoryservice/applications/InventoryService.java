package com.dmall.inventoryservice.applications;

import com.dmall.inventoryservice.domain.Inventory;
import com.dmall.inventoryservice.domain.InventoryLock;
import com.dmall.inventoryservice.infrastructure.exception.CustomizeException;
import com.dmall.inventoryservice.infrastructure.repositories.InventoryLockRepository;
import com.dmall.inventoryservice.infrastructure.repositories.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private InventoryLockRepository inventoryLockRepository;

    public void createInventory(Inventory inventory) {
        inventoryRepository.save(inventory);
    }

    public long lockInventory(InventoryLock inventoryLock) {
        Inventory inventory = inventoryRepository.getByProductId(inventoryLock.getProductId());
        if (inventory.getQuantity() < inventoryLock.getQuantity()) {
            throw new CustomizeException("not enough inventory");
        }
        return inventoryLockRepository.save(inventoryLock);
    }

    @Transactional
    public void deductInventory(long inventoryLockId) {
        InventoryLock inventoryLock = inventoryLockRepository.getInventoryLockById(inventoryLockId);
        inventoryLockRepository.delete(inventoryLock.getId());
        Inventory inventory = inventoryRepository.getByProductId(inventoryLock.getProductId());
        inventory.deduct(inventoryLock.getQuantity());
        inventoryRepository.update(inventory);
    }
}
