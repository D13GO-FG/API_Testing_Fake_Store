package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getProduct extends BaseTest{
    @Test
    public void testGetProduct(ITestContext context){
        int id = (int) context.getSuite().getAttribute("id");
        Response response = given()
                .spec(requestSpecification)
                .pathParams("id", id)
                .when()
                .get(APIConstants.getProduct);
        assertActions.verifyStatusCode(response);
        System.out.println(response.body().prettyPeek());
    }
}
