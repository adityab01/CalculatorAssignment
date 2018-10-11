package com.fxcalc.service.impl;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import com.fxcalc.helper.ReferenceDataLoader;
import com.fxcalc.model.ConversionRequest;

/**
 * 
 * @author Aditya Bhanose
 *@category Test class
 */

@RunWith(MockitoJUnitRunner.class)
public class CurrencyConversionServiceImplTest {
	
	@InjectMocks
	CurrencyConversionServiceImpl mockCurrencyConversionServiceImpl;
	
	@Mock
	ConversionRequest mockconvRequest;
	
	@Mock
	ReferenceDataLoader mockreferenceDataLoader;
	
	
	@Before
	public void setup(){
			
		mockconvRequest = new ConversionRequest();
		mockconvRequest.setToCurrency("USD");
		mockconvRequest.setFromCurrency("AUD");
		mockconvRequest.setAmount(1.1);
	}
	
	@Test
	public void testprocessRequest() {
		mockCurrencyConversionServiceImpl.processRequest(mockconvRequest);
	}

	@Test(expected=NullPointerException.class)
	public void testprocessRequestInvalidInput() throws Exception {
		mockconvRequest = new ConversionRequest();
		mockconvRequest.setToCurrency("ABC");
		mockconvRequest.setFromCurrency("AUD");
		mockconvRequest.setAmount(1.1);
		mockCurrencyConversionServiceImpl.processRequest(mockconvRequest);
	}

	
}
	
	
	