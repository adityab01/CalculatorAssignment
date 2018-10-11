package com.fxcalc.helper;

import java.util.HashMap;

import org.springframework.stereotype.Component;

import com.fxcalc.model.ConversionRequest;
import com.fxcalc.model.CrossViaMatrix;

/**
 * 
 * @author Aditya Bhanose
 * @version 1.0
 */

@Component(value = "referenceDataLoader")
public class ReferenceDataLoader {

	/**
	 * Method to lookup Cross via Matrix
	 * 
	 * @param convRequest
	 * @return
	 */
	public static String lookupCrossMatrix(ConversionRequest convRequest) {

		HashMap<String, HashMap<String, String>> crossMatrix = CrossViaMatrix.getInstance().getMatrixMap();
		HashMap<String, String> map = crossMatrix.get(convRequest.getFromCurrency());
		String value = map.get(convRequest.getToCurrency());
		return value;
	}
}