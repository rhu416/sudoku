package com.sudokudemo;

public class SimplifyMethod {
	public static final int OptionOne = 1;
	public static final int OptionTwo = 2;

	public int AMethod(boolean first, boolean second, boolean third) {
		if (!first) {
			if (second) {
				if (third) {
					return OptionOne;
				} else if (!second) {
					return OptionTwo;
				} else {
					return OptionOne;
				}
			} else {
				return OptionOne;
			}
		} else if (!third) {
			if (!second) {
				return OptionTwo;
			}
		} else if (!second) {
			return OptionTwo;
		}
		if (!(third || !second)) {
			return OptionTwo;
		}
		return OptionOne;
	}

	
	public int AMethodSimplified(boolean first, boolean second, boolean third) {
		if (!first) {
			return OptionOne;
		} else if (!second){
			return OptionTwo;
		}
		if (!third) {
			return OptionTwo;
		}
		
		return OptionOne;
		
	}

}
