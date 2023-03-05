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
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "email"), userDetails.getEmail(), "Email is wrong");
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "password"), userDetails.getPassword(), "Password is wrong");
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "avatar"), userDetails.getAvatar(), "Avatar is wrong");

        int id = apiActions.getDataFromJsonPath(response, "id");
        context.getSuite().setAttribute("id", id);
        //If is required using a new user in authentication when create a new values in context.
//        context.getSuite().setAttribute("email", apiActions.getDataFromJsonPath(response, "email"));
//        context.getSuite().setAttribute("password", apiActions.getDataFromJsonPath(response, "password"));

        System.out.println(response.body().prettyPeek());
    }
}
