package com.samplework.client.domain.impl;

import com.samplework.client.domain.IFoodItems;

public class FoodItems extends CompleteItems implements IFoodItems{
	public FoodItems(String name , double price ,int quality, boolean isImported ){
		super(name, price, quality, isImported );
		super.setSalesTaxPercent(IFoodItems.SALES_TAX_FOOD);
	}
}