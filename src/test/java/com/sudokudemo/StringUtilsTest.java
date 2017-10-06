package com.sudokudemo;

import org.junit.Assert;
import org.junit.Test;

import com.sudokudemo.StringUtils;

public class StringUtilsTest {
	StringUtils strUtils = new StringUtils();
	
	@Test
	public void testIsMirrorSequenceTrue() {
		Assert.assertTrue(strUtils.IsMirrorSequence("kayak"));
		
		Assert.assertTrue(strUtils.IsMirrorSequence("Able was I ere I saw Elba"));
	}
	
	@Test
	public void testIsMirrorSequenceFalse() {
		Assert.assertFalse(strUtils.IsMirrorSequence("kayTak"));
		
		Assert.assertFalse(strUtils.IsMirrorSequence("Able was I eTre I saw Elba"));
	}
}
