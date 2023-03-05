package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.json.JSONObject;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class authentication extends BaseTest{
    @Test
    public void testAuthentication(ITestContext context){
        JSONObject data = new JSONObject();
        data.put("email", "john@mail.com");
        data.put("password", "changeme");
//        data.put("email", context.getSuite().getAttribute("email"));
//        data.put("password", context.getSuite().getAttribute("password"));

        Response response = given()
                .spec(requestSpecification)
                .body(data.toString())
                .when()
                .post(APIConstants.authJWT);

        assertActions.verifyStatusCode(response);
        String access_toke = apiActions.getDataFromJsonPath(response, "access_token");
        String refresh_token = apiActions.getDataFromJsonPath(response, "refresh_token");
        assertActions.verifyResponseBodyValueNotNull(access_toke);
        assertActions.verifyResponseBodyValueNotNull(refresh_token);

        context.getSuite().setAttribute("email", data.getString("email"));
        context.getSuite().setAttribute("password", data.getString("password"));

        context.getSuite().setAttribute("access_token", access_toke);
        context.getSuite().setAttribute("refresh_token", refresh_token);

        System.out.println(response.body().prettyPeek());

    }
}
