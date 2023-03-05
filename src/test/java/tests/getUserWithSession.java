package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getUserWithSession extends BaseTest{
    @Test
    public void testGetUserWithSession(ITestContext context){
        String bearerToken = (String) context.getSuite().getAttribute("access_token");
        Response response = given()
                .spec(requestSpecification)
                .header("Authorization", "Bearer " + bearerToken)
                .when()
                .get(APIConstants.authSession);
        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "email"), (String) context.getSuite().getAttribute("email"), "Email is not equal to email used on authentication credentials");
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "password"), (String) context.getSuite().getAttribute("password"), "Password is not equal to password used on authentication credentials");
        System.out.println(response.body().prettyPeek());
    }
}
