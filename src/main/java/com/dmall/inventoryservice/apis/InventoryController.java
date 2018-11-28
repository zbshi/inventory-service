package com.dmall.inventoryservice.apis;

import com.dmall.inventoryservice.apis.dtos.InventoryCreateRequest;
import com.dmall.inventoryservice.apis.dtos.InventoryDeductionRequest;
import com.dmall.inventoryservice.apis.dtos.InventoryLockRequest;
import com.dmall.inventoryservice.applications.InventoryFactory;
import com.dmall.inventoryservice.applications.InventoryLockFactory;
import com.dmall.inventoryservice.applications.InventoryService;
import com.dmall.inventoryservice.domain.Inventory;
import com.dmall.inventoryservice.domain.InventoryLock;
import com.dmall.inventoryservice.model.InventoryView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventories")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    @GetMapping
    public List<InventoryView> getInventories() {
        return null;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createInventory(@RequestBody InventoryCreateRequest inventoryCreateRequest) {
        Inventory inventory = InventoryFactory.ToDomain(inventoryCreateRequest.getProductId(), inventoryCreateRequest.getQuantity());
        inventoryService.createInventory(inventory);
    }

    @PostMapping("/lock")
    @ResponseStatus(HttpStatus.CREATED)
    public void createInventory(@RequestBody InventoryLockRequest inventoryLockRequest) {
        InventoryLock inventoryLock = InventoryLockFactory.ToDomain(inventoryLockRequest.getProductId(), inventoryLockRequest.getQuantity());
        inventoryService.lockInventory(inventoryLock);
    }

    @PutMapping("/deduction")
    public void deductInventory(@RequestBody InventoryDeductionRequest inventoryDeductionRequest) {
        inventoryService.deductInventory(inventoryDeductionRequest.getProductId(),
                inventoryDeductionRequest.getQuantity());
    }


}
