package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getFilterByJoin extends BaseTest{
    @Test
    public void testGetFilterByJoin1(){
        Response response = given()
                .spec(requestSpecification)
                .queryParam("title", "Generic")
                .queryParam("price_min", 900)
                .queryParam("price_max", 1000)
                .queryParam("categoryId", 1)
                .when()
                .get(APIConstants.createProduct);
        assertActions.verifyStatusCode(response);
        System.out.println(response.body().prettyPeek());
    }

    @Test
    public void testGetFilterByJoin2(){
        Response response = given()
                .spec(requestSpecification)
                .queryParam("price_min", 950)
                .queryParam("price_max", 1000)
                .queryParam("categoryId", 1)
                .when()
                .get(APIConstants.createProduct);
        assertActions.verifyStatusCode(response);
        System.out.println(response.body().prettyPeek());
    }

    @Test
    public void testGetFilterByJoin3(){
        Response response = given()
                .spec(requestSpecification)
                .queryParam("price_min", 100)
                .queryParam("price_max", 1000)
                .queryParam("offset", 10)
                .queryParam("limit", 10)
                .when()
                .get(APIConstants.createProduct);
        assertActions.verifyStatusCode(response);
        System.out.println(response.body().prettyPeek());
    }
}
