package tests;

import io.restassured.response.Response;
import org.fakeStore.endpoints.APIConstants;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class getFilterByCategory extends BaseTest{
    @Test
    public void testGetFilterByCategory(){
        Response response = given()
                .spec(requestSpecification)
                .queryParam("categoryId", 1)
                .when()
                .get(APIConstants.createProduct);
        assertActions.verifyStatusCode(response);
        assertActions.verifyResponseBodyElementContentString(apiActions.getDataFromJsonPath(response, "[0].category.name"), "Clothes", "Title don't content category clothes");
        System.out.println(response.body().prettyPeek());
    }
}
