package com.receiptGeneration.taxCalculation.controller.service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.receiptGeneration.taxCalculation.controller.dao.SalesTaxRepository;
import com.receiptGeneration.taxCalculation.model.Item;

@Service
public class SalesTaxService {

	private static final double BASIC_SALES_TAX_RATE = 0.10;
	private static final double IMPORT_DUTY_TAX_RATE = 0.05;

	@Autowired
	private SalesTaxRepository salesTaxRepository;

	public void addItem(Item item) {
		salesTaxRepository.save(item);
	}

	public void addItems(List<Item> items) {
		salesTaxRepository.saveAll(items);
	}

	public List<Item> getAllItems() {
		return salesTaxRepository.findAll();
	}

	public Item getItemByName(String name) {
		return salesTaxRepository.findByName(name).orElse(null);
	}

	private double roundToNearest05(double value) {
		return new BigDecimal(Math.ceil(value * 20.0) / 20.0).setScale(2, RoundingMode.HALF_UP).doubleValue();
	}

	private double calculateTaxForItem(Item item) {
		double tax = 0.0;

		if (!item.getCategory().isExempt()) {
			tax += item.getPrice() * BASIC_SALES_TAX_RATE;
		}

		if (item.isImported()) {
			tax += item.getPrice() * IMPORT_DUTY_TAX_RATE;
		}

		return roundToNearest05(tax);
	}

	public String generateReceipt(List<Item> items) {
		double totalTaxes = 0.0;
		double totalPrice = 0.0;

		StringBuilder receipt = new StringBuilder();

		for (Item item : items) {
			double itemTax = calculateTaxForItem(item);
			double finalPrice = item.getPrice() + itemTax;

			totalTaxes += itemTax;
			totalPrice += finalPrice;

			receipt.append(String.format("1 %s: %.2f%n", item.getName(), finalPrice));
		}

		receipt.append(String.format("Sales Taxes: %.2f%n", totalTaxes));
		receipt.append(String.format("Total: %.2f%n", totalPrice));

		return receipt.toString();
	}
}
