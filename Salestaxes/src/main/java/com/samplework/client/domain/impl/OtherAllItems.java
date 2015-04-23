package com.samplework.client.domain.impl;

import com.samplework.client.domain.IOtherItems;

public class OtherAllItems extends CompleteItems implements IOtherItems {

	public OtherAllItems(String name, double price, int quality,
			boolean isImported) {
		super(name, price, quality, isImported);
		super.setSalesTaxPercent(IOtherItems.SALES_TAX_DFT);
	}
	
}
