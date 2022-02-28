package com.tqpp;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class CalculatorTest {
	
	Calculator c;
	
	CalculatorTest()
	{
		System.out.println("in def");
	}
	@BeforeAll
	static void all()
	{
		System.out.println("in all");
	}
	
	@BeforeEach
	void start()
	{
		System.out.println("in start");
		c=new Calculator();
	}

	
	@BeforeEach
	void start2()
	{
		System.out.println("in start22222");
		
	}
	
	@Test
	@Order(2)
	void test1() {
		System.out.println("in 111");
		int expected=12;
		int x=c.add(10,2);
		assertEquals(expected,x);
	}
	
	@Test
	@Order(1)
	void test2() {
		System.out.println("in 22222");
		int expected=8;
		int x=c.add(10,-2);
		assertEquals(expected,x);
	}
	
	@Test
	void test3()
	{
		assertTrue(c.iseven(10),"Not even");
	}

	@Test
	void test4()
	{
		assertThrows(ArithmeticException.class,()->c.div(10,0));
	}
}
