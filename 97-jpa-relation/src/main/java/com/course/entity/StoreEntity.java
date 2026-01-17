package com.course.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "STORE")
public class StoreEntity {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String name;

    @OneToOne
    @JoinColumn(name = "id", referencedColumnName = "store_id", insertable = false, updatable = false)
    private StoreProfileEntity profile;

    @OneToMany(mappedBy = "store")
    private List<InventoryEntity> inventories;
}
