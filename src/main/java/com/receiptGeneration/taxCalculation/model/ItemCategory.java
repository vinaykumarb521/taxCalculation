package com.receiptGeneration.taxCalculation.model;

public enum ItemCategory {
	BOOK(true), FOOD(true), MEDICAL(true), OTHER(false); 

	private final boolean exempt;

	ItemCategory(boolean exempt) {
		this.exempt = exempt;
	}

	public boolean isExempt() {
		return exempt;
	}
}
