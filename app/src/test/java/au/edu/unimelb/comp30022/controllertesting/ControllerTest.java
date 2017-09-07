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

    private EditText sourcePostCode;
    private EditText destPostCode;
    private TextView costLabel;


    @Before
    public void setUp() throws Exception {

        UI.addWidget("CALCULATE_BUTTON", new Button());
        sourcePostCode = new EditText();
        sourcePostCode.setText("3055");
        UI.addWidget("SOURCE_POST_CODE", sourcePostCode);
        destPostCode = new EditText();
        destPostCode.setText("3010");
        UI.addWidget("DESTINATION_POST_CODE", destPostCode);
        costLabel = new TextView();
        UI.addWidget("COST_LABEL", costLabel);

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void calculateButtonPressed() throws Exception {
        AddressTools addressToolsMock = Mockito.mock(AddressTools.class);
        PostcodeValidator postcodeValidatorMock = Mockito.mock(PostcodeValidator.class);
        PostageRateCalculator postageRateCalculatorMock = Mockito.mock(PostageRateCalculator.class);

        Controller test = new Controller(addressToolsMock,postcodeValidatorMock,postageRateCalculatorMock);

        Mockito.when(postageRateCalculatorMock.computeCost(any(Location.class),any(Location.class))).thenReturn(5);
        Mockito.when(postcodeValidatorMock.isValid(any(String.class))).thenReturn(true);

        test.calculateButtonPressed();

        Mockito.verify(postageRateCalculatorMock).computeCost(any(Location.class),any(Location.class));

        assertEquals("$5",costLabel.getText());

    }

}