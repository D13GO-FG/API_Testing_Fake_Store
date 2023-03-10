package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import java.util.ArrayList;

import static io.restassured.RestAssured.given;

public class createProduct extends BaseTest{
    @Test
    public void testCreateProduct(ITestContext context){
        Response response = given()
                .spec(requestSpecification)
                .body(requestPayloads.setProductPayload())
                .when()
                .post(APIConstants.createProduct);

        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "title"), "Pikachu pijana", "The title isn't right.");
        assertActions.verifyResponseBody(apiActions.getDataFromJsonPath(response, "price"), 500, "The price isn't right.");
        assertActions.verifyResponseBody((String) apiActions.getDataFromJsonPath(response, "description"), "Pijamas Unisexo Franela Adulto Cosplay Pikachu", "The description isn't right.");
        assertActions.verifyResponseBody((ArrayList) apiActions.getDataFromJsonPath(response, "images"), "https://www.dhresource.com/albu_844327653_00/temp2.0x0.jpg", "The image isn't there.");

        int id = apiActions.getDataFromJsonPath(response, "id");
        context.getSuite().setAttribute("id", id);
        System.out.println("Product ID is: " + id);
    }
}
