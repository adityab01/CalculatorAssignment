package com.fxcalc.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fxcalc.command.ConversionCommand;
import com.fxcalc.command.CurrencyCommand;
import com.fxcalc.command.DirectFeedCommand;
import com.fxcalc.command.InversionCommand;
import com.fxcalc.command.UnityCommand;
import com.fxcalc.model.ConversionRequest;

@RunWith(MockitoJUnitRunner.class)
public class CommandFactoryTest {

	@InjectMocks
	CommandFactory mockCommandFactory;

	@Mock
	ConversionRequest mockconvRequest;

	@Mock
	ConversionCommand mockcommand;

	String mockCrossMatrixValue;

	@Before
	public void setup() {
		mockconvRequest.setAmount(1.0);
		mockconvRequest.setFromCurrency("NZD");
		mockconvRequest.setToCurrency("DKK");
	}

	@Test
	public void testGetCommandObject() {

		mockcommand = CommandFactory.getCommandObject(mockconvRequest, "D");
		boolean result = (mockcommand instanceof DirectFeedCommand);
		assertTrue(result);

		mockcommand = CommandFactory.getCommandObject(mockconvRequest, "INV");
		result = (mockcommand instanceof InversionCommand);
		assertTrue(result);

		mockcommand = CommandFactory.getCommandObject(mockconvRequest, "1:1");
		result = (mockcommand instanceof UnityCommand);
		assertTrue(result);

		mockcommand = CommandFactory.getCommandObject(mockconvRequest, "USD");
		result = (mockcommand instanceof CurrencyCommand);
		assertTrue(result);
	}
}
