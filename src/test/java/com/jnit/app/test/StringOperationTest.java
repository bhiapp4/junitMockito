package com.jnit.app.test;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import com.jnit.app.StringOperation;
//@Ignore
//@Before
//@After
//@BeforeClass
//@AfterClass
public class StringOperationTest {

	StringOperation s = new StringOperation();
	
	@Test
	public void testRepeatedChars(){
		Assert.assertTrue(s.checkForRepeatedChars("hello"));
	}
	
	@Test
	public void testRepeatedCharsempty(){
		Assert.assertFalse(s.checkForRepeatedChars(""));
	}

	@Test
	public void testRepeatedCharsNull(){
		Assert.assertFalse(s.checkForRepeatedChars(null));
	}
	
	@Test
	public void testRepeatedCharsNonRepeating(){
		StringOperation s = new StringOperation();
		StringOperation s1 = Mockito.spy(s);
		Mockito.when(s1.checkIfNullOrEmpty(Mockito.anyString())).thenReturn(false);
		Assert.assertFalse(s1.checkForRepeatedChars("bar"));
	}
}
