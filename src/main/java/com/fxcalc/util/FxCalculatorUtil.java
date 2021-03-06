package com.fxcalc.util;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;

import com.fxcalc.model.ReferenceData;

/**
 * 
 * @author Aditya Bhanose
 * @version 1.0 Utility class for calculator
 */

public class FxCalculatorUtil {

	@Autowired
	ReferenceData referenceRates;

	static HashMap<String, String> formatterMap;

	public static void displayFormattedAmount(String toCurrency, Double amount) {

		formatterMap = ReferenceData.getInstance().getFormatterMap();
		String formattedAmount = String.format("%." + formatterMap.get(toCurrency) + "f %n", amount);
		System.out.println("\n Converted amount from Utils class:" + formattedAmount);

	}

}