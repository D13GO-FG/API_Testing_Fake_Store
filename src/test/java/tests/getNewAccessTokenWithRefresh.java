package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getNewAccessTokenWithRefresh extends BaseTest{
    @Test
    public void testGetNewAccessToken(ITestContext context){
        JSONObject data = new JSONObject();
        data.put("refreshToken", context.getSuite().getAttribute("refresh_token"));

        Response response = given()
                .spec(requestSpecification)
                .body(data.toString())
                .when()
                .post(APIConstants.authRefresh);

        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseBodyNotEqual(apiActions.getDataFromJsonPath(response, "access_token"), (String) context.getAttribute("access_token"), "New access token isn't different");
        assertActions.verifyResponseBodyNotEqual(apiActions.getDataFromJsonPath(response, "refresh_token"), (String) context.getAttribute("refresh_token"), "New refresh token isn't different");

        System.out.println(response.body().prettyPeek());
    }
}
