package com.mvnshrikanth.expenseservices.util;

import java.time.LocalTime;

public class Utils {

	private Utils() {
		throw new IllegalStateException("Utility class");
	}

	public static LocalTime today() {
		return LocalTime.now();
	}

}
