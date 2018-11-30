package com.dmall.inventoryservice.infrastructure.repositories;

import com.dmall.inventoryservice.domain.InventoryLock;
import com.dmall.inventoryservice.infrastructure.repositories.entity.InventoryLockEntity;
import com.dmall.inventoryservice.infrastructure.repositories.persistence.InventoryLockPersistence;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryLockRepository {

    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    private InventoryLockPersistence repository;

    public Long save(InventoryLock inventoryLock) {
        InventoryLockEntity inventory = mapper.map(inventoryLock, InventoryLockEntity.class);
        return repository.save(inventory).getId();
    }
}
