package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getPagination extends BaseTest{
    @Test
    public void testGetPagination(){
        Response response = given()
                .spec(requestSpecification)
                .queryParam("offset", 0)
                .queryParam("limit", 10)
                .when()
                .get(APIConstants.createProduct);
        assertActions.verifyStatusCode(response);
        assertActions.verifySizeList(response.jsonPath().getList("$").size(), 10, "Aren't 10 json classes");
        System.out.println(response.body().prettyPeek());
    }
}
