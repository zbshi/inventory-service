package com.dmall.inventoryservice.infrastructure.repositories.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "inventory_lock")
public class InventoryLockEntity {

    @Id
    @GeneratedValue
    Long id;

    @Column(name = "product_id")
    long productId;

    @Column(name = "quantity")
    int quantity;

}
