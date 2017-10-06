package com.sudokudemo;

import org.junit.Assert;
import org.junit.Test;

import com.sudokudemo.SimplifyMethod;

public class SimplifyMethodTest {
	protected SimplifyMethod sm = new SimplifyMethod();
	
	@Test
	public void testMethod() {
		int result = sm.AMethod(true, true, true);
		int resultS = sm.AMethodSimplified(true,  true, true);
		Assert.assertEquals(result, resultS);
		

		result = sm.AMethod(true, true, false);
		resultS = sm.AMethodSimplified(true,  true, false);
		Assert.assertEquals(result, resultS);
		
		result = sm.AMethod(true, false, true);
		resultS = sm.AMethodSimplified(true,  false, true);
		Assert.assertEquals(result, resultS);
		
		result = sm.AMethod(true, false, false);
		resultS = sm.AMethodSimplified(true,  false, false);
		Assert.assertEquals(result, resultS);
	
		result = sm.AMethod(false, true, true);
		resultS = sm.AMethodSimplified(false,  true, true);
		Assert.assertEquals(result, resultS);
		
		result = sm.AMethod(false, true, false);
		resultS = sm.AMethodSimplified(false,  true, false);
		Assert.assertEquals(result, resultS);
		
		result = sm.AMethod(false, false, true);
		resultS = sm.AMethodSimplified(false,  false, true);
		Assert.assertEquals(result, resultS);
		
		result = sm.AMethod(false, false, false);
		resultS = sm.AMethodSimplified(false,  false, false);
		Assert.assertEquals(result, resultS);
	}
}
