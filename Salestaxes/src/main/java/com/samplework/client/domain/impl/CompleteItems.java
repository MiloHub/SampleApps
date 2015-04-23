package com.samplework.client.domain.impl;

import com.samplework.client.domain.IProducts;


public class CompleteItems  implements IProducts {

	public double getSalesTaxPercent() {
		return salesTaxPercent;
	}

	public void setSalesTaxPercent(double salesTaxPercent) {
		this.salesTaxPercent = salesTaxPercent;
	}

	private boolean isImported;
	
	private double salesTaxPercent;
	
	public boolean isImported() {
		return isImported;
	}
	
	public CompleteItems(String name , double price ,int quality, boolean isImported ){
		this.name = name;
		this.nosQuality = quality;
		this.isImported = isImported;
		this.price = price;
	}

	public void setImported(boolean isImported) {
		this.isImported = isImported;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price * nosQuality;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getNosQuality() {
		return nosQuality;
	}

	public void setNosQuality(int nosQuality) {
		this.nosQuality = nosQuality;
	}

	private String name;
	
	private double price;
	
	private int nosQuality;
	
	/**
	 * to Calculate Sales Tax for items added
	 * 
	 * 
	 */
	public double calculateSalesTax(){
		
		  double totalSalesTaxForThisProduct;
          if (isImported) {
                  totalSalesTaxForThisProduct = ((this.salesTaxPercent + IProducts.IMPORT_DUTY_FOR_IMPORTED)
                                  * this.price * this.nosQuality) / 100;

          } else
                  totalSalesTaxForThisProduct = (this.salesTaxPercent * this.price * this.nosQuality) / 100;

          return totalSalesTaxForThisProduct;
	}
	
	
	

}
