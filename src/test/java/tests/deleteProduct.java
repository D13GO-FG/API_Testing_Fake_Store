package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class deleteProduct extends BaseTest{
    @Test
    public void testDeleteProduct(ITestContext context){
        int id = (int) context.getSuite().getAttribute("id");
        Response response = given()
                .spec(requestSpecification)
                .pathParams("id", id)
                .when()
                .delete(APIConstants.deleteProduct);
        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseTrue(response, "The response is False, and is expected True");
        System.out.println(response.body().prettyPeek());
    }
}
