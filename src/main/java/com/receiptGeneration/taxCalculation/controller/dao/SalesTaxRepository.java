
package com.receiptGeneration.taxCalculation.controller.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.receiptGeneration.taxCalculation.model.Item;

public interface SalesTaxRepository extends JpaRepository<Item, Long> {
	Optional<Item> findByName(String name);
}
