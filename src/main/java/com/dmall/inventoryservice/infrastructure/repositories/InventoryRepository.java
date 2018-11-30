package com.dmall.inventoryservice.infrastructure.repositories;

import com.dmall.inventoryservice.infrastructure.repositories.persistence.InventoryPersistence;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class InventoryRepository {

    private static final ModelMapper mapper = new ModelMapper();

    @Autowired
    private InventoryPersistence repository;
}