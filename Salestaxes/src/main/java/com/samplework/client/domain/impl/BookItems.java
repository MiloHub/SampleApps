package com.samplework.client.domain.impl;

import com.samplework.client.domain.IBookItems;

public class BookItems extends CompleteItems implements IBookItems {

	public BookItems(String name, double price, int quality, boolean isImported) {
		super(name, price, quality, isImported);
		super.setSalesTaxPercent(IBookItems.SALES_TAX_BOOKS);
	}

}
