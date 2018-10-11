package com.fxcalc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fxcalc.command.ConversionCommand;
import com.fxcalc.command.CurrencyConvertor;
import com.fxcalc.factory.CommandFactory;
import com.fxcalc.helper.ReferenceDataLoader;
import com.fxcalc.model.ConversionRequest;
import com.fxcalc.service.CurrencyConversionService;

/**
 * 
 * @author Aditya Bhanose
 * @version 1.0 Service class provides the currency conversion
 */

@Component(value = "currencyConversionService")
public class CurrencyConversionServiceImpl implements CurrencyConversionService {

	@Autowired
	CurrencyConvertor currencyConv;

	/**
	 * Method to process the input request
	 */
	@Override
	public void processRequest(ConversionRequest convRequest) {

		currencyConv = new CurrencyConvertor();
		String crossMatrixValue = ReferenceDataLoader.lookupCrossMatrix(convRequest);

		ConversionCommand conversionCommand = CommandFactory.getCommandObject(convRequest, crossMatrixValue);
		currencyConv.setCommand(conversionCommand);
		conversionCommand.execute();

		if (!convRequest.getCrossCurrency().isEmpty()) {
			processRequest(convRequest);
		}

	}

}