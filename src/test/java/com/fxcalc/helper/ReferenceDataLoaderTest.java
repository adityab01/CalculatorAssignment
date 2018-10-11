package com.fxcalc.helper;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.fxcalc.model.ConversionRequest;
import com.fxcalc.model.CrossViaMatrix;



@RunWith(MockitoJUnitRunner.class)
public class ReferenceDataLoaderTest {
	
	@InjectMocks
	ReferenceDataLoader mockReferenceDataLoader;
	
	@Mock
	ConversionRequest mockconvRequest;
	
	@Mock
	CrossViaMatrix mockcrossViaMatrix;
	
	
	HashMap<String, HashMap<String, String>> mockcrossMatrix;// = CrossViaMatrix.getInstance().getMatrixMap();
	HashMap<String, String> mockMap; //= crossMatrix.get(convRequest.getFromCurrency())
	
	@Before
	public void setup() {
		mockconvRequest=new ConversionRequest();
		mockconvRequest.setAmount(1.0);
		mockconvRequest.setFromCurrency("AUD");
		mockconvRequest.setToCurrency("USD");
		
		mockMap= new HashMap<String, String>();
		mockMap.put("AUD", "1");
		mockMap.put("USD", "INV");
		
		mockcrossMatrix= new HashMap<String, HashMap<String, String>>();
		mockcrossMatrix.put("AUD", mockMap);
		mockcrossViaMatrix =CrossViaMatrix.getInstance();
		
	}

	@Test
	public void testLookupCrossViaMatrix(){
		String value=mockReferenceDataLoader.lookupCrossMatrix(mockconvRequest);
		assertEquals(value, "D");
		
	}
	
	
	
}