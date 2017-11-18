package testclasses;

import static org.junit.Assert.*;

import org.junit.Test;

import stockmanagement.Item;
import stockmanagement.Stock;
import stockmanagement.StockFactory;
import stockmanagement.Stockitem;

public class Teststock {

	@Test
	public void testStock() {
		StockFactory fact = StockFactory.getStockFactory();
		Stock myStock = fact.createStock();
		myStock.registerItem(0, "Testbrand", "Testarticle", 3.15, 5);
		Item myItem = myStock.getItem(0, 1);
		
		assertTrue(myItem!=null);
		assertTrue(myStock.getItem(0, 1).getClass()==Stockitem.class);
		assertFalse(myStock.getItem(5, 3)!=null);
		assertTrue(myItem.getAmount()==1);
		assertTrue(myItem.getArticle()=="Testarticle");
		assertTrue(myItem.getBrand()=="Testbrand");
		assertTrue(myItem.getNr()==0);
		assertTrue(myItem.getPrice()==3.15);
		assertFalse(myItem.getItem(5));
		
		Item myItem2 = myStock.getItem(0, 5);
		
		assertTrue(myItem2!=null && myItem2.getAmount()==3);
	}

}
