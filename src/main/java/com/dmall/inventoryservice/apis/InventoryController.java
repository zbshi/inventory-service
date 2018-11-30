package com.dmall.inventoryservice.apis;

import com.dmall.inventoryservice.apis.dtos.InventoryCreateRequest;
import com.dmall.inventoryservice.applications.InventoryFactory;
import com.dmall.inventoryservice.applications.InventoryService;
import com.dmall.inventoryservice.domain.Inventory;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    private InventoryService inventoryService;

    @Autowired
    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @ApiOperation(value = "创建库存")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInventory(@RequestBody InventoryCreateRequest inventoryCreateRequest) {
        Inventory inventory = InventoryFactory.toDomain(inventoryCreateRequest.getProductId(), inventoryCreateRequest.getQuantity());
        inventoryService.save(inventory);
    }
}
