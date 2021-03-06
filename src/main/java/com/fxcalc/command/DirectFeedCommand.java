package com.fxcalc.command;

import java.util.HashMap;

import com.fxcalc.model.ConversionRequest;
import com.fxcalc.model.ReferenceData;
import com.fxcalc.util.FxCalculatorUtil;

/**
 * 
 * @author Aditya Bhanose
 * @version 1.0 Implementation of Direct command
 *
 */

public class DirectFeedCommand implements ConversionCommand {

	ConversionRequest convRequest;

	public DirectFeedCommand(ConversionRequest convRequest) {

		this.convRequest = convRequest;

	}

	@Override
	public void execute() {
		HashMap<String, String> ratesMap = ReferenceData.getInstance().getRatesMap();
		String strRate = ratesMap.get(convRequest.getFromCurrency().concat(convRequest.getToCurrency()));
		Double rate = Double.parseDouble(strRate);
		FxCalculatorUtil.displayFormattedAmount(convRequest.getToCurrency(), rate * convRequest.getAmount());

	}

}