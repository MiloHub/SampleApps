package com.samplework;

import junit.framework.TestSuite;

import com.samplework.factory.ProductFactoryTest;


public class SalesTaxTestSuite extends TestSuite {
	
	  public static TestSuite suite()
	    {
	        TestSuite suite = new TestSuite();  
	        suite.addTestSuite(ProductFactoryTest.class);
	        suite.addTestSuite(CompleteItemsTest.class);
	        return suite;
	    }

}
