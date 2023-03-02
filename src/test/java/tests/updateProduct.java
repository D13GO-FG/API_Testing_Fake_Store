package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class updateProduct extends BaseTest{
    @Test
    public void testUpdateProduct(ITestContext context){
        int id = (int) context.getSuite().getAttribute("id");
        Response response = given()
                .spec(requestSpecification)
                .pathParams("id", id)
                .body(requestPayloads.setToUpdateProductPayload())
                .when()
                .put(APIConstants.updateProduct);
        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "title"), "Yoda pijana", "The value title is not updated.");
        assertActions.verifyResponseBody(apiActions.getDataFromJsonPath(response, "price"), 550, "The price is not updated.");
        System.out.println(response.body().prettyPeek());
    }
}
