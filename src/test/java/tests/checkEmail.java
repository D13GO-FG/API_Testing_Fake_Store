package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class checkEmail extends BaseTest{
    @Test
    public void verifyCheckEmail(ITestContext context){
        String setEmail = (String) context.getSuite().getAttribute("email");

        JSONObject data = new JSONObject();
        data.put("email", setEmail);

        Response response = given()
                .spec(requestSpecification)
                .body(data.toString())
                .when()
                .post(APIConstants.checkEmail);

        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseBody(apiActions.getDataFromJsonPath(response, "isAvailable"), "Email is not registered");
        System.out.println(response.body().prettyPeek());
    }
}
