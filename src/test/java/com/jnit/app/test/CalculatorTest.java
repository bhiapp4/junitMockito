package com.jnit.app.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.jnit.app.Calculator;
import com.jnit.app.StringOperation;

import org.junit.Assert;

public class CalculatorTest {
	
	@Mock
	private Calculator calculator;
	
	@Before
	public void init(){
		MockitoAnnotations.initMocks(this);
		Mockito.when(calculator.add(1, 2)).thenReturn(3);
		Mockito.when(calculator.add(-1, -2)).thenReturn(-3);
		Mockito.when(calculator.add(0, 0)).thenReturn(0);
		Mockito.when(calculator.add(1, -2)).thenReturn(-1);
		
		Mockito.when(calculator.mul(0, 2)).thenReturn(0);
		Mockito.when(calculator.mul(1, 2)).thenReturn(2);
		Mockito.when(calculator.mul(-1, -2)).thenReturn(2);
		Mockito.when(calculator.mul(-1, 2)).thenReturn(-2);
		
		Mockito.when(calculator.div(10, 5)).thenReturn(2);
		Mockito.when(calculator.div(10, 0)).thenThrow(new ArithmeticException("Divide by zero error"));
	}
	
	@Test
	public void testAdd(){
		Assert.assertEquals(3, calculator.add(1, 2));		
		Assert.assertEquals(-3, calculator.add(-1, -2));
		Mockito.verify(calculator).add(-1, -2);
		Mockito.verify(calculator,Mockito.times(1)).add(-1, -2);	
	}

	@Test
	public void testMul(){
		Assert.assertEquals(2, calculator.mul(1, 2));		
		Assert.assertEquals(2, calculator.mul(-1, -2));		
	}
	
	@Test(expected = ArithmeticException.class)
	public void testDiv(){
		Assert.assertEquals(2, calculator.div(10, 5));		
		Assert.assertEquals(2, calculator.div(10, 0));		
	}


}
