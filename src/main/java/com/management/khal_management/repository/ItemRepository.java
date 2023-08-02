package com.management.khal_management.repository;

import com.management.khal_management.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
    Item save(Item item);
}
