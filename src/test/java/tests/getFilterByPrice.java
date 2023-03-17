package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getFilterByPrice extends BaseTest{
    @Test
    public void testGetFilterByPrice(){
        Response response = given()
                .spec(requestSpecification)
                .queryParam("price", 100)
                .when()
                .get(APIConstants.createProduct);
        assertActions.verifyStatusCode(response);
        System.out.println(response.body().prettyPeek());
    }
}
