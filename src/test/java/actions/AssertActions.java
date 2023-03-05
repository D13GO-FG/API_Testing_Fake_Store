package actions;

import io.restassured.response.Response;

import java.util.ArrayList;

import static org.testng.Assert.*;

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

    public void verifyResponseTrue(Response response, String description){
        assertTrue(response.asString().contains("true"), description);
    }

    public void verifyResponseBody(Boolean isAvailable, String description) {
        assertFalse(isAvailable, description);
    }

    public void verifyResponseContentType(Response response, String expectedType) {
        assertEquals(response.getContentType(), expectedType, "Response content type is not " + expectedType);
    }

    public void verifyResponseBodyValueNotNull(String actual) {
        assertNotNull(actual, actual + " is null");
    }

    public void verifyResponseBodyNotEqual(String actual_access_token, String last_access_token, String description) {
        assertNotEquals(actual_access_token, last_access_token, description);
    }
}
