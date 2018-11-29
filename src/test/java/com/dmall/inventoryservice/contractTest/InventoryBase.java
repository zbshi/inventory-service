package com.dmall.inventoryservice.contractTest;

import com.dmall.inventoryservice.apis.InventoryController;
import com.dmall.inventoryservice.applications.InventoryService;
import com.dmall.inventoryservice.domain.Inventory;
import com.dmall.inventoryservice.domain.InventoryLock;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.junit.Before;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InventoryBase {

    @Before
    public void setup() {
        final InventoryService inventoryService = mock(InventoryService.class);

        doNothing().when(inventoryService).createInventory(any(Inventory.class));
        when(inventoryService.lockInventory(any(InventoryLock.class))).thenReturn(1l);
        doNothing().when(inventoryService).deductInventory(anyLong(), anyLong(), anyInt());
        RestAssuredMockMvc.standaloneSetup(new InventoryController(inventoryService));
    }

}
