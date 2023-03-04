package tests;

import io.restassured.response.Response;
import org.fakeStore.dataObjects.UserDetails;
import org.fakeStore.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class createUser extends BaseTest{
    @Test
    public void testCreateUser(ITestContext context){
        UserDetails userDetails = requestPayloads.setUserPayload();
        Response response = given()
                .spec(requestSpecification)
                .body(userDetails)
                .when()
                .post(APIConstants.createUser);
        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "name"), userDetails.getName(), "Name is wrong");
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "name"), userDetails.getName(), "Name is wrong");
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "email"), userDetails.getEmail(), "Email is wrong");
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "password"), userDetails.getPassword(), "Password is wrong");
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "avatar"), userDetails.getAvatar(), "Avatar is wrong");
        int id = apiActions.getDataFromJsonPath(response, "id");
        context.getSuite().setAttribute("id", id);
        System.out.println(response.body().prettyPeek());
    }
}
