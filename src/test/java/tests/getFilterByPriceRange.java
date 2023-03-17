package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getFilterByPriceRange extends BaseTest{
    @Test
    public void testGetFilterByPriceRange(){
        Response response = given()
                .spec(requestSpecification)
                .queryParam("price_min", 900)
                .queryParam("price_max", 1000)
                .when()
                .get(APIConstants.createProduct);
        assertActions.verifyStatusCode(response);
        System.out.println(response.body().prettyPeek());
    }
}
