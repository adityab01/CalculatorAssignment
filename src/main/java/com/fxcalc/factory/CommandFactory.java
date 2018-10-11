package com.fxcalc.factory;

import com.fxcalc.command.ConversionCommand;
import com.fxcalc.command.CurrencyCommand;
import com.fxcalc.command.DirectFeedCommand;
import com.fxcalc.command.InversionCommand;
import com.fxcalc.command.UnityCommand;
import com.fxcalc.model.ConversionRequest;

/**
 * 
 * @author Aditya Bhanose
 * @version 1.0 Factory class for commands 
 *
 */

public class CommandFactory {

	public static ConversionCommand getCommandObject(ConversionRequest convRequest, String crossMatrixValue) {

		// if Direct Feed
		if (crossMatrixValue.equalsIgnoreCase("D")) {
			convRequest.setCrossCurrency("");
			return new DirectFeedCommand(convRequest);
		}
		// If unity
		else if (crossMatrixValue.equalsIgnoreCase("1:1")) {
			convRequest.setCrossCurrency("");
			return new UnityCommand(convRequest);
		}
		// If Inversion
		else if (crossMatrixValue.equalsIgnoreCase("INV")) {
			convRequest.setCrossCurrency("");
			return new InversionCommand(convRequest);
		}
		// If Currency
		else {
			convRequest.setCrossCurrency(crossMatrixValue);
			return new CurrencyCommand(convRequest);
		}

		// throw new IllegalArgumentException("No such Command");
	}
}
