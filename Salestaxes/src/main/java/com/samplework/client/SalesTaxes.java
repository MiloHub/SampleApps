package com.samplework.client;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.samplework.client.domain.IProducts;
import com.samplework.factory.ProductFactory;
//
public class SalesTaxes {
	List<IProducts> itemsCart = new ArrayList<IProducts>();
	private ProductFactory factory;
	double grand_ST_Total;
	double grand_BC_Total;
	double grandTotal;
	public static void main(String[] args) {
		
		new SalesTaxes().getSalesTaxes();
	}
	
	private void getSalesTaxes(){
		
		factory = ProductFactory.getInstance();
		IProducts item = factory.createProduct(IProducts.BOOK_PRD,
				"book", 12.49, 1, false);
		IProducts item1 = factory.createProduct(IProducts.OTHER, "music CD",
				14.99, 1, false);
		IProducts item2 = factory.createProduct(IProducts.BOOK_PRD,
				"chocolate bar", 0.85, 1, false);

		itemsCart.add(item);
		itemsCart.add(item1);
		itemsCart.add(item2);
		generateBill();
	}


	/**
	 * to generate bill
	 * 
	 */
	private void generateBill() {

		for (IProducts product : itemsCart) {
			int quantity = product.getNosQuality();
			String name = product.getName();
			boolean isImported = product.isImported();
			double total_Base_Cost = product.getPrice();
			double total_Sales_Tax = product.calculateSalesTax();
			double totalCost = total_Base_Cost + total_Sales_Tax;

			grand_ST_Total += total_Sales_Tax;
			grand_BC_Total += total_Base_Cost;

			print(quantity, name, total_Sales_Tax, totalCost, isImported);
		}

		grandTotal = grand_ST_Total + grand_BC_Total;

		System.out.println("Sales Taxes:\t"
				+ new BigDecimal(Double.toString(grand_ST_Total)).setScale(2,
						BigDecimal.ROUND_HALF_EVEN));
		System.out.println("Total:\t"
				+ new BigDecimal(Double.toString(grandTotal)).setScale(2,
						BigDecimal.ROUND_HALF_EVEN) + "\n");
	}
	/**
	 * print the bill
	 * 
	 * */
	public void print(int quality, String name, double total_Sales_Tax,
			double total_Base_Cost, boolean isImported) {

		
		if (isImported){
			System.out.println(quality +" Imported " +name + " : " + total_Base_Cost);
		}else{
			System.out.println(quality+ " "+ name + " : " + total_Base_Cost);
		}
	}

}
