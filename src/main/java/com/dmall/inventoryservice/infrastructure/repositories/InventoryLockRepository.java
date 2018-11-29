package com.dmall.inventoryservice.infrastructure.repositories;

import com.dmall.inventoryservice.domain.InventoryLock;
import com.dmall.inventoryservice.infrastructure.exception.CustomizeException;
import com.dmall.inventoryservice.infrastructure.repositories.entity.InventoryLockEntity;
import com.dmall.inventoryservice.infrastructure.repositories.persistence.InventoryLockPersistence;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InventoryLockRepository {

    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    private InventoryLockPersistence repository;

    public long save(InventoryLock inventoryLock) {
        InventoryLockEntity inventoryLockEntity = mapper.map(inventoryLock, InventoryLockEntity.class);
        return repository.save(inventoryLockEntity).getId();
    }

    public InventoryLock getInventoryLockById(long id) {
        Optional<InventoryLockEntity> inventoryLockEntity = repository.findById(id);
        return inventoryLockEntity.map(lock -> mapper.map(lock, InventoryLock.class))
                .orElseThrow(() -> new CustomizeException("inventory lock not found"));
    }

    public void delete(long inventoryLockId) {
        repository.deleteById(inventoryLockId);
    }
}
