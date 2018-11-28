package com.dmall.inventoryservice.infrastructure.repositories;

import com.dmall.inventoryservice.domain.Inventory;
import com.dmall.inventoryservice.infrastructure.exception.CustomizeException;
import com.dmall.inventoryservice.infrastructure.repositories.entity.InventoryEntity;
import com.dmall.inventoryservice.infrastructure.repositories.persistence.InventoryPersistence;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class InventoryRepository {

    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    private InventoryPersistence repository;

    public void save(Inventory inventory) {
        InventoryEntity existedEntity = repository.findInventoryEntityByProductId(inventory.getProductId());
        if (existedEntity != null) {
            throw new CustomizeException("inventory already exists");
        }
        repository.save(mapper.map(inventory, InventoryEntity.class));
    }

    public Inventory getById(long id) {
        Optional<InventoryEntity> inventoryEntity = repository.findById(id);
        return inventoryEntity.map(entity -> mapper.map(entity, Inventory.class))
                .orElseThrow(() -> new CustomizeException("inventory not found"));
    }

    public Inventory getByProductId(long productId) {
        InventoryEntity existedEntity = repository.findInventoryEntityByProductId(productId);
        return Optional.ofNullable(existedEntity).map(entity -> mapper.map(entity, Inventory.class))
                .orElseThrow(() -> new CustomizeException("inventory not found"));
    }

    public void update(Inventory inventory) {
        repository.save(mapper.map(inventory, InventoryEntity.class));
    }
}