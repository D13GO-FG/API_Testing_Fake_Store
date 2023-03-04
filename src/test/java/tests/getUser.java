package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getUser extends BaseTest{
    @Test
    public void testGetUser(ITestContext context){
        int id = (int) context.getSuite().getAttribute("id");
        Response response = given()
                .spec(requestSpecification)
                .pathParams("id", id)
                .when()
                .get(APIConstants.getUser);
        assertActions.verifyStatusCode(response);
        System.out.println(response.body().prettyPeek());
    }
}
