package com.samplework.factory;

import junit.framework.TestCase;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.samplework.client.domain.IProducts;
import com.samplework.factory.ProductFactory;

public class ProductFactoryTest extends TestCase {

	
    private IProducts item;
    
    private ProductFactory factory;

    @Before
    public void setUp() throws Exception {
            factory = ProductFactory.getInstance();
    }

    
    @Test
    public void testBookObject() {
    	item = factory.createProduct(IProducts.BOOK_PRD, "HeadFirst", 70.00, 2,
                            false);
            assertEquals(item.getName(), "HeadFirst");
            assertTrue(item.getSalesTaxPercent() == 0);
            assertTrue(item.getPrice() == (70 * 2));

    }

    @Test
    public void testImportedBookItem() {
            item = factory.createProduct(IProducts.BOOK_PRD, "HeadFirst jAVA", 55.00, 2,
                            true);
            double salesTax = (55.00 * 2 * IProducts.IMPORT_DUTY_FOR_IMPORTED) / 100;
            assertEquals(item.getName(),"HeadFirst jAVA");
            assertTrue(item.calculateSalesTax() == salesTax);
            assertTrue(item.getPrice() == (55 * 2));

    }

    @Test
    public void testMedicalItem() {
    	item = factory.createProduct(IProducts.MEDICAL_PRD, "Advil", 5.00, 1, false);
    	   assertEquals(item.getName(),"Advil");
           assertTrue(item.calculateSalesTax() == 0);
           assertTrue(item.getPrice() == (5 * 1));

    }

    @Test
    public void testOtherItem() {
    	item = factory.createProduct(IProducts.OTHER, "table", 115.00, 6, false);
            double totalSalesTax = (115.00 * 6 * IProducts.SALES_TAX_DFT) / 100;
            assertEquals(item.getName(),"table");
            assertTrue(item.calculateSalesTax() == totalSalesTax);
            assertTrue(item.getPrice() == (115 * 6));

    }

	
    @After
    public void tearDown() {
            factory = null;
    }


}
