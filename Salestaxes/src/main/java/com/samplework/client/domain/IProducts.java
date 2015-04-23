package com.samplework.client.domain;

public interface IProducts {
	
	
	 public static final String BOOK_PRD = "Book";
     public static final String FOOD_PRD = "Food";
     public static final String MEDICAL_PRD = "Medical";
     public static final String OTHER = "Other";
     
     
	
     public final static double SALES_TAX_DFT = 10;
     public final static double IMPORT_DUTY_FOR_IMPORTED = 5;
    
     public static final int NEAREST_N_CENTS = 5;
     
     public static final int REQUIRED_DECIMAL_PLACES = 2; 
     
     
     public boolean isImported() ;
     public double getSalesTaxPercent();
     public String getName() ;
     public double getPrice() ;
     
     public int getNosQuality() ;
     
     public double calculateSalesTax();
	
	//public boolean is

}
