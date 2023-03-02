package actions;

import io.restassured.response.Response;

import java.util.ArrayList;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AssertActions {
    public void verifyStatusCode(Response response) {
        assertTrue(String.valueOf(response.getStatusCode()).startsWith("20"), "value of status code is" + response.getStatusCode());
    }
    public void verifyResponseBody(String actual, String expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(float actual, float expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(int actual, int expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(double actual, double expected, String description) {
        assertEquals(actual, expected, description);
    }
    public void verifyResponseBody(boolean actual, boolean expected, String description) {
        assertEquals(actual, expected, description);
    }

    public void verifyResponseBody(ArrayList actual, String expected, String description){
        assertTrue(actual.contains(expected), description);
    }
}
