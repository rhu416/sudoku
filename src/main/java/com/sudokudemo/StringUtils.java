package com.sudokudemo;

public class StringUtils {
	public boolean IsMirrorSequence(String s) {
		boolean ret = false;
		String revStr = new StringBuilder(s).reverse().toString();
		ret = s.equalsIgnoreCase(revStr);
		return ret;
	}

}
