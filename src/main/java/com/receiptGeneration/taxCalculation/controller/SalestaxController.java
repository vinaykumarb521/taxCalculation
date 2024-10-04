package com.receiptGeneration.taxCalculation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.receiptGeneration.taxCalculation.controller.service.SalesTaxService;
import com.receiptGeneration.taxCalculation.model.Item;

@RestController
@RequestMapping("/api/items")
public class SalestaxController {

	@Autowired
	private SalesTaxService itemService;

	@PostMapping("/add")
	public ResponseEntity<String> addItem(@RequestBody Item item) {
		itemService.addItem(item);
		return new ResponseEntity<>("Item added successfully", HttpStatus.CREATED);
	}

	@PostMapping("/bulk-add")
	public ResponseEntity<String> addItems(@RequestBody List<Item> items) {
		itemService.addItems(items);
		return new ResponseEntity<>("Items added successfully", HttpStatus.CREATED);
	}

	@PostMapping("/receipt")
	public ResponseEntity<String> generateReceipt(@RequestBody List<Item> items) {
		String receipt = itemService.generateReceipt(items);
		if (receipt.isEmpty()) {
			return new ResponseEntity<>("No items available for generating receipt", HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(receipt, HttpStatus.OK);
	}
}
