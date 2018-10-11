package com.fxcalc.service.impl;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fxcalc.model.ConversionRequest;

@RunWith(MockitoJUnitRunner.class)
public class InputValidationServiceTest {

	@InjectMocks
	InputValidationServiceImpl mockInputValidationService;

	@Mock
	ConversionRequest mockconvRequest;

	String inputCommandValid = "";
	String inputCommandInValid = "";

	@Before
	public void setup() {

		mockconvRequest = new ConversionRequest();
		inputCommandValid = "AUD 11 in USD";
		inputCommandInValid = "ABC 1 in PQR";

	}

	@Test
	public void testvalidateInputSuccessScenario() {
		boolean validationResult = mockInputValidationService.validateInput(inputCommandValid, mockconvRequest);
		assertEquals(validationResult, true);
	}

	@Test
	public void testvalidateInputFailScenario() {
		boolean validationresult = mockInputValidationService.validateInput(inputCommandInValid, mockconvRequest);
		assertEquals(validationresult, false);

	}

}
