package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import beverage.*;
import javaMatic.JavaMatic;



class JavaMaticTests {

	@Test
	void consructorTest() {
		JavaMatic jm= new JavaMatic();
		assertEquals(10, jm.getStock("Coffee"));
		assertEquals(10, jm.getStock("Cocoa"));
		assertEquals(10, jm.getStock("Cream"));
		assertEquals(10, jm.getStock("Decaf Coffee"));
		assertEquals(10, jm.getStock("Espresso"));
		assertEquals(10, jm.getStock("Foamed Milk"));
		assertEquals(10, jm.getStock("Steamed Milk"));
		assertEquals(10, jm.getStock("Sugar"));
		assertEquals(10, jm.getStock("Whipped Cream"));
		assertEquals(6, jm.getMenu().size());
	}
	
	@Test
	void coffeePriceTest() {
		JavaMatic jm= new JavaMatic();
		Beverage b= new Coffee();
		double e=.0001;
		double price= jm.getPrice(b);
		double expected= 2.75;
		assertTrue(Math.abs(price-expected)<e);	
	}
	
	@Test
	void decafCofeePriceTest() {
		JavaMatic jm= new JavaMatic();
		Beverage b= new DecafCoffee();
		double e=.0001;
		double price= jm.getPrice(b);
		double expected= 2.75;
		assertTrue(Math.abs(price-expected)<e);	
	}
	
	@Test
	void cappuccinoPriceTest() {
		JavaMatic jm= new JavaMatic();
		Beverage b= new Cappuccino();
		double e=.0001;
		double price= jm.getPrice(b);
		double expected= 2.90;
		assertTrue(Math.abs(price-expected)<e);	
	}
	
	@Test
	void caffeMochaPriceTest() {
		JavaMatic jm= new JavaMatic();
		Beverage b= new CaffeMocha();
		double e=.0001;
		double price= jm.getPrice(b);
		double expected= 3.35;
		assertTrue(Math.abs(price-expected)<e);	
	}
	@Test
	void caffeLattePriceTest() {
		JavaMatic jm= new JavaMatic();
		Beverage b= new CaffeLatte();
		double e=.0001;
		double price= jm.getPrice(b);
		double expected= 2.55;
		assertTrue(Math.abs(price-expected)<e);	
	}
	@Test
	void caffeAmericanoPriceTest() {
		JavaMatic jm= new JavaMatic();
		Beverage b= new CaffeAmericano();
		double e=.0001;
		double price= jm.getPrice(b);
		double expected= 3.30;
		assertTrue(Math.abs(price-expected)<e);	
	}
	
	@Test
	void orderDrinkTest() {
		JavaMatic jm= new JavaMatic();
		Beverage b= new CaffeAmericano();
		jm.orderDrink(b);
		assertEquals(7, jm.getStock("Espresso"));
		jm.orderDrink(b);
		jm.orderDrink(b);
		assertEquals(1, jm.getStock("Espresso"));
		assertFalse(jm.available(b));
		jm.orderDrink(b);
		assertEquals(1, jm.getStock("Espresso"));
	}
	
	void restockTest() {
		JavaMatic jm= new JavaMatic();
		Beverage b= new CaffeAmericano();
		jm.orderDrink(b);
		jm.orderDrink(b);
		jm.orderDrink(b);
		assertFalse(jm.available(b));
		jm.reStock();
		assertTrue(jm.available(b));
		assertEquals(10, jm.getStock("Espresso"));
	}
	
	
	

}
