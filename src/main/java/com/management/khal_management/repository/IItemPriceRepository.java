package com.management.khal_management.repository;

import com.management.khal_management.model.ItemPriceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IItemPriceRepository extends JpaRepository<ItemPriceModel, Long> {
}
