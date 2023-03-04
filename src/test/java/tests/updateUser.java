package tests;

import io.restassured.response.Response;
import org.fakeStore.dataObjects.UserDetails;
import org.fakeStore.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class updateUser extends BaseTest{
    @Test
    public void testUpdateUser(ITestContext context){
        UserDetails userDetails = requestPayloads.setToUpdateUserPayload();
        int id = (int) context.getSuite().getAttribute("id");
        Response response = given()
                .spec(requestSpecification)
                .pathParams("id", id)
                .body(userDetails)
                .when()
                .put(APIConstants.updateUser);
        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "name"), userDetails.getName(), "Name didn't update");
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "email"), userDetails.getEmail(), "Email didn't update");
        System.out.println(response.body().prettyPeek());
    }
}
