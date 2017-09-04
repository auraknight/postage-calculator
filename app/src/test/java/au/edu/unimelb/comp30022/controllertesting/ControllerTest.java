package au.edu.unimelb.comp30022.controllertesting;

import android.location.Location;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;
import static org.mockito.Matchers.any;


/**
 * Created by John on 31/08/2017.
 */
public class ControllerTest {

    @Before
    public void setUp() throws Exception {


    AddressTools addressToolsMock = Mockito.mock(AddressTools.class);
    PostcodeValidator postcodeValidatorMock = Mockito.mock(PostcodeValidator.class);
    PostageRateCalculator postageRateCalculatorMock = Mockito.mock(PostageRateCalculator.class);

    Controller test = new Controller(addressToolsMock,postcodeValidatorMock,postageRateCalculatorMock);

    Mockito.when(postageRateCalculatorMock.computeCost(any(Location.class),any(Location.class))).thenReturn(5);
    Mockito.when(postcodeValidatorMock.isValid(any(String.class))).thenReturn(true);

    test.calculateButtonPressed();


    Mockito.verify(postageRateCalculatorMock.computeCost(any(Location.class),any(Location.class)));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void calculateButtonPressed() throws Exception {

    }

}