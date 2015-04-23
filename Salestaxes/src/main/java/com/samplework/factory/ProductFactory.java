package com.samplework.factory;

import com.samplework.client.domain.IProducts;
import com.samplework.client.domain.impl.BookItems;
import com.samplework.client.domain.impl.FoodItems;
import com.samplework.client.domain.impl.MedicalItems;
import com.samplework.client.domain.impl.OtherAllItems;

public class ProductFactory  {
	
	private static ProductFactory instance;		
		 public static ProductFactory getInstance() {
             if (instance == null) {
                     instance = new ProductFactory();
             }
             return instance;
    }

     private ProductFactory() {

     }

     public IProducts createProduct(String productType, String name, double price, int quantity,
                     boolean isImported) {

    	 IProducts product = null;

             if (productType.equals(IProducts.BOOK_PRD)) {
                     product = new BookItems(name, price, quantity, isImported);
             } else if (productType.equals(IProducts.FOOD_PRD)) {
                     product = new FoodItems(name, price, quantity, isImported);
             } else if (productType.equals(IProducts.MEDICAL_PRD)) {
                     product = new MedicalItems(name, price, quantity, isImported);
             } else {
                     product = new OtherAllItems(name, price, quantity, isImported);
             }

             return product;
     }

	

}
