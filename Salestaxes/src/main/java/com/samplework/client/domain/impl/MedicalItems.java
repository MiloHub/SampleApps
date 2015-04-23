package com.samplework.client.domain.impl;

import com.samplework.client.domain.IMedItems;

public class MedicalItems extends CompleteItems implements IMedItems{
	public MedicalItems(String name , double price ,int quality, boolean isImported ){
		super(name, price, quality, isImported );
		super.setSalesTaxPercent(IMedItems.SALES_TAX_MEDICAL);
	}
}
